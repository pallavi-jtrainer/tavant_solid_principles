package com.tavant.SRP_Demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tavant.SRP_Demo.entity.Customer;
import com.tavant.SRP_Demo.entity.Order;
import com.tavant.SRP_Demo.repository.OrderRepository;
import com.tavant.SRP_Demo.service.discount.DiscountStrategy;
import com.tavant.SRP_Demo.service.shipping.ShippingService;


@Service
public class OrderService {

	private final OrderRepository repo;
	private final OrderNotificationService notification;
	private final OrderValidationService validation;
	private final ShippingService shipping;
	private final Map<String, DiscountStrategy> strategies;
	
	public OrderService(OrderRepository repo, 
		OrderNotificationService notification,
		OrderValidationService validation,
		ShippingService shipping,
		Map<String, DiscountStrategy> strategies) { 
			this.repo = repo; 
			this.notification = notification;
			this.validation =validation;
			this.shipping = shipping;
			this.strategies = strategies;
	}
	
	public void createOrder(Order order, Customer customer) {
		
		double weight = 3.5;
		double shippingCost = shipping.calculateShippingAmount(order.getAmount(), weight);
		
		DiscountStrategy strategy = strategies.get(customer.getCustomerType().name().toLowerCase());
		
		double discount = strategy.applyDiscount(order, customer);
		
		double total = order.getAmount() + shippingCost - discount;
		
		order.setAmount(total);
		
		
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
