package apache.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class Producer{
    public static void main(String[] args) {
        try{
            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY,"org.apache.activemq.jndi.ActiveMQInitialContextFactory");
            props.setProperty(Context.PROVIDER_URL,"tcp://localhost:61616");


            // Obtain a JNDI connection
            InitialContext jndi = new InitialContext(props);

            // Look up a JMS connection factory
            ConnectionFactory conFactory = (ConnectionFactory) jndi
                    .lookup("ConnectionFactory");
//            ActiveMQConnectionFactory conFactory = new ActiveMQConnectionFactory();
            Connection connection = conFactory.createConnection();
            connection.start();

            // JMS messages are sent and received using a Session. We will
            // create here a non-transactional session object. If you want
            // to use transactions you should set the first parameter to 'true'
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

            Destination destination = (Destination) jndi.lookup("MESSAGE.TRANSMITTER");
            MessageProducer producer = session.createProducer(destination);

            String message = "Hello from " + Thread.currentThread().getName()
                    + " at " + (new SimpleDateFormat("dd-mm-yyyy HH:MM:ss")).format(new Date()) + " ;";
            TextMessage tx = session.createTextMessage(message);
            producer.send(tx);
            session.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
