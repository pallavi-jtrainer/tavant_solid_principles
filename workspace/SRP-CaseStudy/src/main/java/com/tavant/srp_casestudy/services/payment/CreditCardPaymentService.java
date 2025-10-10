package com.tavant.srp_casestudy.services.payment;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.entity.Member;

@Service
public class CreditCardPaymentService implements CreditCardPayment, RefundablePayment {
	
	@Override
	public void payByCreditCard(double amount) {
		System.out.println("Processing payment for amount: " + amount + " with Credit Card");
	}
	
	@Override
	public void refund(Member member, double amount) {
		System.out.println("Refunding amount: " + amount + " to :" + member.getFirstName() + " " + member.getLastName());
		
	}
}
