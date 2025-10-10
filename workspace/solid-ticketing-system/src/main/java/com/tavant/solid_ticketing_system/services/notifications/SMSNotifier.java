package com.tavant.solid_ticketing_system.services.notifications;

import org.springframework.stereotype.Component;

@Component("smsNotifier")
public class SMSNotifier implements Notifier{

	@Override
	public void send(String recipient, String message) {
		System.out.println("SMS sent to " + recipient + ": " + message);
		
	}

}
