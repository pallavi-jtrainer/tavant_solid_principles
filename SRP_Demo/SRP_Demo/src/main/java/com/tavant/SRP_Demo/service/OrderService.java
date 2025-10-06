package com.tavant.SRP_Demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.SRP_Demo.entity.Order;
import com.tavant.SRP_Demo.repository.OrderRepository;


@Service
public class OrderService {

	private final OrderRepository repo;
	private final OrderNotificationService notification;
	private final OrderValidationService validation;
	
	public OrderService(OrderRepository repo, 
		OrderNotificationService notification,
		OrderValidationService validation) { 
			this.repo = repo; 
			this.notification = notification;
			this.validation =validation;
	}
	
	public void createOrder(Order order) {
		
////		if(order.getAmount() <= 0) {
////			throw new IllegalAccessException("Invalid order amount");
////		}
//		
//		Order  o = repo.save(order);
//		
////		System.out.println("Order created. Email sent to Customer");
//		return o;
		
		if(validation.validateOrder(order)) {
			repo.save(order);
			notification.sendOrderConfirmationNotification("xyz@abc.com");
		}
	}
}
