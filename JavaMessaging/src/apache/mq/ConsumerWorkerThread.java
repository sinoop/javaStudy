package apache.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class ConsumerWorkerThread implements Runnable {
    static Object consumerLock = new Object();

    @Override
    public void run() {


        ActiveMQConnectionFactory conFactory;
        Connection connection = null;
        synchronized (consumerLock) {
            try {
                System.out.println("Running..." + Thread.currentThread().getName());
                //1. Create a Connection Factory to the MQ server
                conFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

                //2. Create a Connection
                connection = conFactory.createConnection();
                connection.start();
                //3. Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                //4. Create a destination
                Destination destination = session.createQueue("MESSAGE.TRANSMITTER");

                //5.Create a ProducerWorkerThread
                MessageConsumer consumer = session.createConsumer(destination);

                //6.Wait for message
                Message ms = consumer.receive(1000);

                if (ms instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) ms;
                    String text = textMessage.getText();
                    System.out.println("Received: " + text);
                } else {
                    System.out.println("Received: " + ms);
                }
                consumer.close();
                session.close();
                connection.close();

                Thread.sleep(1000);

            } catch (JMSException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

            }
        }


    }
}
