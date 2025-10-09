package com.tavant.srp_casestudy.services;

import com.tavant.srp_casestudy.entity.Book;
import com.tavant.srp_casestudy.entity.Member;

public interface ReservationNotificationService {

	void notifyReservationAvailability(Member member, Book book);
}
