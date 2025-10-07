package com.tavant.SRP_Demo.service;

import com.tavant.SRP_Demo.entity.Order;

public interface PaymentProcessor {
	void processPayment(Order order);
}
