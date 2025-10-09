package com.tavant.solid_ticketing_system.entity;

import com.tavant.solid_ticketing_system.utils.CustomerType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customers")
@Getter
@Setter @NoArgsConstructor
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false, unique=true)
	private String email;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CustomerType type;
	
	public Customer(String firstName, String lastName, String email, CustomerType type) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
	}
	
	
}
