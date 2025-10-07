package com.tavant.SRP_Demo.service;

import org.springframework.stereotype.Component;

import com.tavant.SRP_Demo.entity.Order;

@Component("CREDIT_CARD")
public class CreditCardProcessor implements PaymentProcessor{

	@Override
	public void processPayment(Order order) {
		System.out.println("Paying using Credit Card");
		
	}

}
