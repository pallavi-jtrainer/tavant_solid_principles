package com.tavant.SRP_Demo.service.shipping;

import org.springframework.stereotype.Service;

@Service
public class ExpressShippingService implements ShippingService{

	@Override
	public double calculateShippingAmount(double orderAmount, double weight) {
		return 100 + (weight * 20);
	}

}
