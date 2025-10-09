package com.tavant.solid_ticketing_system.entity;

import java.time.LocalDate;

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
@Table(name = "events")
@Getter
@Setter @NoArgsConstructor
@ToString
public class Event {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String eventName;
	
	@Column(nullable = false)
	private String location;
	
	@Column(nullable = false)
	private LocalDate date;
	
	@Column(nullable = false)
	private int availableTickets;

	public Event(String eventName, String location, LocalDate date, int availableTickets) {
		this.eventName = eventName;
		this.location = location;
		this.date = date;
		this.availableTickets = availableTickets;
	}
	
	
}
