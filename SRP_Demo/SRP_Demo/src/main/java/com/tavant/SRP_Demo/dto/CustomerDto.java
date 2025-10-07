package com.tavant.SRP_Demo.dto;

import com.tavant.SRP_Demo.utils.CustomerType;

import lombok.Data;

@Data
public class CustomerDto {

	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private CustomerType customerType;
}
