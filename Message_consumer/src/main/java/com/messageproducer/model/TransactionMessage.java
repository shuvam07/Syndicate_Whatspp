package com.messageproducer.model;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
public class TransactionMessage extends Message implements Serializable {
	private String contactNumber;
	public TransactionMessage(Long messageId, String message, int messageType, Timestamp timeStamp,
			String contactNumber) {
		super(messageId, message, messageType, timeStamp);
		this.contactNumber = contactNumber;
	}
	@Override
	public String toString() {
		return "TransactionMessage [contactNumber=" + contactNumber + ", Message()=" + super.toString() + "]";
	}
	public String getContactNumber() {
		// TODO Auto-generated method stub
		return this.contactNumber;
	}
}
