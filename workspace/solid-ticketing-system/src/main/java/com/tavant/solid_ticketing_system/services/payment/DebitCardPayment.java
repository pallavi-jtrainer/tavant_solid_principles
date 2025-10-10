package com.tavant.solid_ticketing_system.services.payment;

import org.springframework.stereotype.Component;

@Component("debitCardPayment")
public class DebitCardPayment implements PaymentStrategy{

	@Override
	public boolean pay(double amount) {
		System.out.println("Paid " + amount + " via Debit Card");
		return true;
	}

	
}
