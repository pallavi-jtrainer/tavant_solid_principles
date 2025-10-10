package com.tavant.solid_ticketing_system.services.payment;

import org.springframework.stereotype.Component;

@Component("creditCardPayment")
public class CreditCardPayment implements PaymentStrategy {

	@Override
	public boolean pay(double amount) {
		System.out.println("Paid " + amount + " via Credit Card");
		return true;
	}

}
