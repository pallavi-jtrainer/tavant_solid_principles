package com.tavant.srp_casestudy.services.impl;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.services.NotificationService;

@Service("smsService")
public class SmsNotificationService implements NotificationService {

	@Override
	public void send(String to, String message) {
		System.out.println("SMS sent to " + to + ": " + message);
	}

}
