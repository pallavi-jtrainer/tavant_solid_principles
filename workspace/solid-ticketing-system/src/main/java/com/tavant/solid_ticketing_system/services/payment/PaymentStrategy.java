package com.tavant.solid_ticketing_system.services.payment;

public interface PaymentStrategy {
	boolean pay(double amount);
}
