package com.tavant.srp_casestudy.services;

import com.tavant.srp_casestudy.entity.Loan;
import com.tavant.srp_casestudy.entity.Member;

public interface ReminderNotificationService {

	void sendDueReminderNotification(Member member, Loan loan);
}
