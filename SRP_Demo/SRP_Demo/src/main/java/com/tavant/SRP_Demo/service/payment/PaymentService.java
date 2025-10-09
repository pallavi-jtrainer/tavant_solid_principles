package com.tavant.SRP_Demo.service.payment;

public interface PaymentService { //fat interface <- Not recommended
	void processCreditCardPayment(double amount);
	void processDebitCardPayment(double amount);
	void processUpiPayment(double amount);
}
