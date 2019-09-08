package com.messageproducer.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@Configuration
@EnableJms
public class Config {
	
	@Value("${activemq.broker-url}")
	private String BROKER_URL ;
	@Value("${activemq.username}")
	private String BROKER_USERNAME;
	@Value("${activemq.password}")
	private String BROKER_PASSWORD;
	
	@Bean
	@Qualifier("ActiveMQConnectionFactory")
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(BROKER_URL);
		activeMQConnectionFactory.setUserName(BROKER_USERNAME);
		activeMQConnectionFactory.setPassword(BROKER_PASSWORD);
		System.out.println("Creating connectionfactory");
		return activeMQConnectionFactory;
	}
		
}
