package org.rsd.test4;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@SpringJUnitConfig
@ContextConfiguration("classpath:activeMQ.xml")
public class Test5 {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    @Qualifier("queue1JmsTemplate")
    private JmsTemplate queue1JmsTemplate;

    @Autowired
    @Qualifier("queue2")
    private ActiveMQQueue queue;

    @Resource
    private ActiveMQTopic topic2;

    @Test
    public void send() {
        queue1JmsTemplate.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("我爱学习。");
            }
        });
//        jmsTemplate.send(topic2, new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage("我爱北京");
//            }
//        });
    }

    @Test
    public void receive() throws JMSException {
        while (true) {
            Message message = jmsTemplate.receive(queue);
            TextMessage textMessage = (TextMessage) message;
            System.out.println(textMessage.getText());
        }
    }
}
