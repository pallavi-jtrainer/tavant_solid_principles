package com.tavant.SRP_Demo.service.shipping;

public interface ShippingService {
	double calculateShippingAmount(double orderAmount, double weight);
}
