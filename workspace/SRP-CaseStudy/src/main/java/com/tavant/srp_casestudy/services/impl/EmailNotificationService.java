package com.tavant.srp_casestudy.services.impl;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.services.NotificationService;

@Service("emailService")
public class EmailNotificationService implements NotificationService{

	@Override
	public void send(String to, String message) {
		System.out.println("Email sent to " + to + ": " + message);
		
	}

}
