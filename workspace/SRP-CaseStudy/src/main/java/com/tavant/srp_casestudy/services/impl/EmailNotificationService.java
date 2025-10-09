package com.tavant.srp_casestudy.services.impl;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.entity.Book;
import com.tavant.srp_casestudy.entity.Loan;
import com.tavant.srp_casestudy.entity.Member;
import com.tavant.srp_casestudy.services.NotificationService;
import com.tavant.srp_casestudy.services.ReminderNotificationService;
import com.tavant.srp_casestudy.services.ReservationNotificationService;

@Service("emailService")
public class EmailNotificationService implements NotificationService, 
	ReminderNotificationService, ReservationNotificationService {

	@Override
	public void send(String to, String message) {
		System.out.println("Email sent to " + to + ": " + message);
		
	}

	@Override
	public void notifyReservationAvailability(Member member, Book book) {
		System.out.println("Reminder: " + member.getFirstName() + " " + member.getLastName()
			+ ", your reserved book " + book.getTitle() + " is now available");
		
	}

	@Override
	public void sendDueReminderNotification(Member member, Loan loan) {
		System.out.println("Reminder: " + member.getFirstName() + " " + member.getLastName()
		+ ", please return the book: " + loan.getBook().getTitle() + 
		" by due date: " + loan.getDueDate());
	}

}
