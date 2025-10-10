package com.tavant.solid_ticketing_system.services.payment;

import org.springframework.stereotype.Component;

@Component("upiPayment")
public class UpiPayment implements PaymentStrategy{

	@Override
	public boolean pay(double amount) {
		System.out.println("Paid " + amount + " via UPI");
		return true;
	}

}
