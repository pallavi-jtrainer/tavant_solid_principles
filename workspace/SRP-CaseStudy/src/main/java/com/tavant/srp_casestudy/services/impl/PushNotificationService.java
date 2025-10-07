package com.tavant.srp_casestudy.services.impl;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.services.NotificationService;

@Service("pushService")
public class PushNotificationService implements NotificationService {

	@Override
	public void send(String to, String message) {
		System.out.println("Push notification sent to " + to + ": " + message);
	}

}
