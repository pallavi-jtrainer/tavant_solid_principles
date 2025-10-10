package com.tavant.solid_ticketing_system.services.notifications;

import org.springframework.stereotype.Component;

@Component("emailNotifier")
public class EmailNotifier implements Notifier{

	@Override
	public void send(String recipient, String message) {
		System.out.println("Email sent to " + recipient + ": " + message);
		
	}

}
