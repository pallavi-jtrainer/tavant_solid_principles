package com.tavant.srp_casestudy.services.payment;

import org.springframework.stereotype.Service;

@Service
public class UpiPaymentService implements UpiPayment {

	@Override
	public void payByUpi(double amount) {
		System.out.println("Processing payment for amount: " + amount + " using UPI");
	}
}
