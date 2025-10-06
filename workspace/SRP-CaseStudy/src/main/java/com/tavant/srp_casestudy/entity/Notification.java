package com.tavant.srp_casestudy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="notifications")
@Getter @Setter @NoArgsConstructor
@ToString
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	private String type;
	
	@Column(nullable = false)
	private String message;
	
	public Notification(String type, String message) {
		this.type = type;
		this.message = message;
	}
	
	
}
