package com.tavant.SRP_Demo.service.shipping;

import org.springframework.stereotype.Service;

@Service
public class StandardShippingService implements ShippingService{

	@Override
	public double calculateShippingAmount(double orderAmount, double weight) {
			return 50 + (weight * 10);
	}

}
