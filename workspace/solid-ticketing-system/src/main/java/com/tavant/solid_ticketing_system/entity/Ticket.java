package com.tavant.solid_ticketing_system.entity;

import java.time.LocalDate;

import com.tavant.solid_ticketing_system.utils.TicketType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tickets")
@Getter
@Setter @NoArgsConstructor
@ToString
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@ManyToOne
	private Customer customer;
	
	@Column(nullable = false)
	@ManyToOne
	private Event event;
	
	@Column(nullable = false)
	private TicketType ticketType;
	
	@Column(nullable = false)
	private double price;

	public Ticket(Customer customer, Event event, TicketType ticketType, double price) {
		this.customer = customer;
		this.event = event;
		this.ticketType = ticketType;
		this.price = price;
	}
	
	
}
