package com.tavant.solid_ticketing_system.services.notifications;

public interface EmailNotification {
	void sendEmail(String to, String message);
}
