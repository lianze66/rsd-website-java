package org.rsd.test4;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;

public class Test1_Queue_send {

    @Test
    public void sendMessage() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Queue queue = session.createQueue("lianze");
        MessageProducer producer = session.createProducer(queue);
        Message message = session.createTextMessage("我爱北京天安门。");
        producer.send(message);

        producer.close();
        session.close();
        connection.close();
    }
}
