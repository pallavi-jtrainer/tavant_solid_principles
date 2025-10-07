package com.tavant.SRP_Demo.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.tavant.SRP_Demo.entity.Order;
//import com.tavant.SRP_Demo.utils.PaymentType;

@Service
public class CheckoutService {
	
	private final Map<String, PaymentProcessor> processors;

	public CheckoutService(Map<String, PaymentProcessor> processors) {
		this.processors = processors;
	}
	
	public void pay(Order order) {
		PaymentProcessor p = processors.get(order.getPaymentType().name());
		
		if(p == null) throw new RuntimeException("Payment Type Not Found");
		
		p.processPayment(order);
	}

//	public void pay(Order order) {
//		if(order.getPaymentType() == PaymentType.CREDIT_CARD) {
//			// credit card logic
//		} else if(order.getPaymentType() == PaymentType.DEBIT_CARD) {
//			//debit card logic
//		}
//	}
}
