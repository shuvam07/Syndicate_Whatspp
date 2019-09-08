package com.messageproducer.model;

import lombok.Data;

@Data
public class Customer {
	private Long customerId;
	private String customerName;
	private String contactNum;
}
