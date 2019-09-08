package com.whatsapp.consumer;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
@SpringBootApplication
@EnableJms
public class NotificationConsumerApplication {
	private static final Logger logger=LoggerFactory.getLogger(NotificationConsumerApplication.class);
	public static final String SYND_SINGLE_SMS_QUEUE="synd-single-sms-queue";
	public static void main(String[] args) {
		SpringApplication.run(NotificationConsumerApplication.class, args);
	}
}
