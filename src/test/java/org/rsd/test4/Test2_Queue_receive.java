package org.rsd.test4;

import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;
import java.io.IOException;

public class Test2_Queue_receive {

    @Test
    public void receive1() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("lianze");
        MessageConsumer consumer = session.createConsumer(queue);
        while (true) {
            Message message = consumer.receive();
            if (message != null) {
                TextMessage textMessage = (TextMessage)message;
                System.out.println(textMessage.getText());
            } else {
                break;
            }
        }

        consumer.close();
        session.close();
        connection.close();
    }

    @Test
    public void receive2() throws JMSException, IOException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("lianze");
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {

            @SneakyThrows
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage)message;
                System.out.println(textMessage.getText());
            }
        });

        System.in.read();

        consumer.close();
        session.close();
        connection.close();
    }
}
