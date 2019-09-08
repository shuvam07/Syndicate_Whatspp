package com.messageproducer.producer;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.messageproducer.model.TransactionMessage;

@Component
public class ProduceMessage {

	private JmsTemplate jmsTemplate;
	private ActiveMQConnectionFactory connectionFactory;
	private Boolean TRANSACTIONAL = false;
	
	public ProduceMessage(final ActiveMQConnectionFactory activeMQConnectionFactory) {
		this.connectionFactory=activeMQConnectionFactory;
		this.jmsTemplate = new JmsTemplate();
		this.jmsTemplate.setConnectionFactory(activeMQConnectionFactory);
	}
	
	public void publishMessage(TransactionMessage transactionMsg) throws JMSException  {
		Connection connection = connectionFactory.createConnection();
		connection.start();
		Session session = connection.createSession(TRANSACTIONAL,
                Session.AUTO_ACKNOWLEDGE);
		ObjectMessage msg = session.createObjectMessage(transactionMsg);
        msg.setJMSType("OBJECT");
        jmsTemplate.convertAndSend("transaction.queue",msg);
		System.out.println(transactionMsg.getClass());
		return ;
	}
}
