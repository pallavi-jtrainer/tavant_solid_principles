package com.tavant.srp_casestudy.services;

import java.util.EnumMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.tavant.srp_casestudy.utils.NotificationType;

@Component
public class NotificationFactory {

	private final Map<NotificationType, NotificationService> services = new EnumMap<>(NotificationType.class);
	
	public NotificationFactory(
			@Qualifier("emailService") NotificationService emailService,
			@Qualifier("smsService") NotificationService smsService,
			@Qualifier("pushService") NotificationService pushService) {
		
		services.put(NotificationType.EMAIL, emailService);
		services.put(NotificationType.SMS, smsService);
		services.put(NotificationType.PUSH, pushService);
	}
	
	public NotificationService getService(NotificationType type) {
		return services.getOrDefault(type, services.get(NotificationType.EMAIL));
	}
}
