package com.messageproducer.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.messageproducer.model.TransactionMessage;
import com.messageproducer.producer.ProduceMessage;

@CrossOrigin
@RestController
@RequestMapping("/gateway/publish")
@Component
public class PostMessageController {
	
	@Autowired
	private ActiveMQConnectionFactory activeMQConnectionFactory;
	private static Long id=(long) 1;	
	
	
	@GetMapping("/send/mType/{mType}/contactNum/{contactNum}/message/{message}")
	@ResponseBody
	void PostTransactionMessage(@PathVariable int mType, @PathVariable String contactNum, @PathVariable String message) {
		try {
			Date date= new Date();
			System.out.println(message);
			Timestamp timeStamp = new Timestamp(date.getTime());
			TransactionMessage transactionMsg = new TransactionMessage(id++, message, mType, timeStamp, contactNum);
			ProduceMessage producer = new ProduceMessage(activeMQConnectionFactory);
			producer.publishMessage(transactionMsg);
		} catch(JMSException ex) {
			System.out.println(ex.getMessage());
		} finally {
			System.out.println("Message Published!!!");
		}
		
	}
}