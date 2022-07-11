package org.rsd.test4;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.junit.jupiter.api.Test;

import javax.jms.*;

public class Test3_Topic_send {

    @Test
    public void send() throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = factory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Topic topic = session.createTopic("andy");
        MessageProducer producer = session.createProducer(topic);
        Message message = session.createTextMessage("我爱山西。");
        producer.send(message);

        producer.close();
        session.close();
        connection.close();
    }
}
