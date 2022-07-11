package org.rsd.test4;

import lombok.SneakyThrows;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;
import java.io.IOException;

public class Test1 {

    @Test
    public void write() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("lianze");
        MessageProducer producer = session.createProducer(queue);
        TextMessage textMessage = session.createTextMessage("我爱北京天安门。");
        producer.send(textMessage);

        producer.close();
        session.close();
        connection.close();
    }

    @Test
    public void read() throws JMSException, IOException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("lianze");
        MessageConsumer consumer = session.createConsumer(queue);
//        Message message = consumer.receive();
//        System.out.println(message);
        consumer.setMessageListener(new MessageListener() {
            @SneakyThrows
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println(textMessage.getText());
            }
        });

        System.in.read();

        consumer.close();
        session.close();
        connection.close();
    }
}
