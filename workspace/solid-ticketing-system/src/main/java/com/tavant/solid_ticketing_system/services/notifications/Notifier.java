package com.tavant.solid_ticketing_system.services.notifications;

public interface Notifier {

	void send(String recipient, String message);
}
