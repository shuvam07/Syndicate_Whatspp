package com.whatsapp.consumer;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;




@Configuration
public class SystemConfiguration {
	
	private static final Logger logger=LoggerFactory.getLogger(SystemConfiguration.class);
	@Value("${active-mq-url}")
	private String activeMqUrl;
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue(NotificationConsumerApplication.SYND_SINGLE_SMS_QUEUE);
	}
	 /*@Bean // Serialize message content to json using TextMessage
	    public MessageConverter jacksonJmsMessageConverter() {
	        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	        converter.setTargetType(MessageType.TEXT);
	       converter.setTypeIdPropertyName("com.print.and.post.system.entiry.UINRequest");
	        return converter;
	    }*/
	@Bean
	public ActiveMQConnectionFactory connectionFactory() {
		
		//ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory();
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		System.out.println("Creating Active Mq Broker On "+activeMqUrl);
		logger.info("Creating Active Mq Broker On "+activeMqUrl);
		factory.setBrokerURL(activeMqUrl);
		factory.setUserName("admin");
		factory.setPassword("admin");
		
		return factory;
	}
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFactory());
	}
}
