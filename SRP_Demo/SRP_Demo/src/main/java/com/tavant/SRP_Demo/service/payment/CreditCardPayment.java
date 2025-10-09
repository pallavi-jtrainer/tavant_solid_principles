package com.tavant.SRP_Demo.service.payment;

public interface CreditCardPayment {

	void checkCardValidity(String cardNumber);
	void processCreditCardPayment(double amount);
}
