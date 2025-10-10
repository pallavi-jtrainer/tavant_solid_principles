package com.tavant.srp_casestudy.services;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.entity.Member;
import com.tavant.srp_casestudy.services.payment.CreditCardPayment;
import com.tavant.srp_casestudy.services.payment.UpiPayment;

@Service
public class FinePaymentService {

	private final CreditCardPayment creditCardPayment;
	private final UpiPayment upiPayment;
	
	public FinePaymentService(CreditCardPayment creditCardPayment, UpiPayment upiPayment) {
		this.creditCardPayment = creditCardPayment;
		this.upiPayment = upiPayment;
	}
	
	public void processFinePayment(Member member, double amount, String method) {
		
		switch(method.toUpperCase()) {
		case "CREDITCARD" -> creditCardPayment.payByCreditCard(amount);
		case "UPI" -> upiPayment.payByUpi(amount);
		default -> throw new IllegalArgumentException("Unsupported payment method");
		}
	}
}
