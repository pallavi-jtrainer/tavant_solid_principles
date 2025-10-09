package com.tavant.solid_ticketing_system.services.notifications;

public class EmailService implements EmailNotification {

	@Override
	public void sendEmail(String to, String message) {
		System.out.println("Email sent to " + to + ": " + message);
		
	}

	
}
