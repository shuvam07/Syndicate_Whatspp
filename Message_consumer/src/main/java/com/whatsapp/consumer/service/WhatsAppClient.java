package com.whatsapp.consumer.service;

import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Slf4j
@Component
public class WhatsAppClient {
	public static final String ACCOUNT_SID="AC9e2ec3e819222baac7d6d520cdf79897";
	public static final String AUTH_TOKEN="a0664845c9fa0e0dc0340a663a2c2159";
	
	
	public void sendNotification(com.messageproducer.model.TransactionMessage msg) {
		String logHead="WhatsAppClient.class sendNotification() :: Message Id-{"+msg.getMessageId()+"} | ";
	    try {
	        /*TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

	        // Build a filter for the MessageList
	        List<NameValuePair> params = new ArrayList<NameValuePair>();
	        params.add(new BasicNameValuePair("Body", msg.getMessage()));
	        params.add(new BasicNameValuePair("To", "whatsapp:+"+msg.getContactNumber())); //Add real number here
	        params.add(new BasicNameValuePair("From","whatsapp:+19403103938"));

	        MessageFactory messageFactory = client.getAccount().getMessageFactory();
	        Message message = messageFactory.create(params);
	     //   System.out.println();*/
	    	System.out.println(msg.getContactNumber());
	    	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	        Message message = Message.creator(
	                new com.twilio.type.PhoneNumber("whatsapp:"+msg.getContactNumber()),
	                new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),msg.getMessage())
	            .create();

	        System.out.println(message.getSid());
	        log.info(logHead+"Message Sending Status :: "+message.getStatus());
	        log.info(logHead+"Message Response :: "+message.toString());
	    } 
	    catch (Exception e) {
	    	log.error(logHead+"Message Exception :: "+e);
	    	System.out.println(e.getMessage());
	    }
	}
}
