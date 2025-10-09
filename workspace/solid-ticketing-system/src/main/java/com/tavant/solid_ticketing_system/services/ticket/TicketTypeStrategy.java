package com.tavant.solid_ticketing_system.services.ticket;

import com.tavant.solid_ticketing_system.entity.Ticket;

public interface TicketTypeStrategy {
	void applyTicketType(Ticket ticket);
}
