package com.tavant.SRP_Demo.service;

import org.springframework.stereotype.Service;

@Service
public class OrderNotificationService {

	public void sendOrderConfirmationNotification(String email) {
		System.out.println("Confirmation sent to Customer on "+ email);
	}
}
