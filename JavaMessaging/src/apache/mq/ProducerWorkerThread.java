package apache.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProducerWorkerThread implements Runnable {
    static Object producerLock = new Object();
    @Override
    public void run() {
        ActiveMQConnectionFactory conFactory;
        Connection connection = null;
        synchronized (producerLock){
            try {
                System.out.println("Running..." + Thread.currentThread().getName());
                Thread.sleep(100);
                //1. Create a Connection Factory to the MQ server
                conFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");

                //2. Create a Connection
                connection = conFactory.createConnection();
                connection.start();

                //3. Create a Session
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

                //4. Create a destination
                Destination destination = session.createQueue("MESSAGE.TRANSMITTER");

                //5.Create a ConsumerWorkerThread
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

                //6.Create Message
                String message = "Hello from " + Thread.currentThread().getName()
                        + " at " + (new SimpleDateFormat("dd-mm-yyyy HH:MM:ss")).format(new Date()) + " ;";
                TextMessage ms = session.createTextMessage(message);

                //7. Let producer send the message
                producer.send(ms);
                session.close();
                connection.close();

            } catch (JMSException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

