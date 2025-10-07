package com.tavant.srp_casestudy.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.entity.Book;
import com.tavant.srp_casestudy.entity.Loan;
import com.tavant.srp_casestudy.entity.Member;
import com.tavant.srp_casestudy.exceptions.ResourceNotFoundException;
import com.tavant.srp_casestudy.repository.LoanRepository;
import com.tavant.srp_casestudy.services.impl.EmailNotificationService;
import com.tavant.srp_casestudy.services.impl.SmsNotificationService;
import com.tavant.srp_casestudy.utils.NotificationType;


@Service
public class LoanService {

	private final LoanRepository loanRepo;
	private final BookService bookService;
	private final MemberService memberService;
	private final EmailNotificationService emailService;
	private final SmsNotificationService smsService;
	private final NotificationFactory factory;
	
	public LoanService(LoanRepository loanRepo, BookService bookService, MemberService memberService,
			EmailNotificationService emailService, SmsNotificationService smsService,
			NotificationFactory factory) {
		this.loanRepo = loanRepo;
		this.bookService = bookService;
		this.memberService = memberService;
		this.emailService = emailService;
		this.smsService = smsService;
		this.factory = factory;
	}
	
	public Loan loanBook(Long bookId, Long memberId, int days, NotificationType notify) {
		Book book = bookService.getBookDetailsById(bookId);
		Member member = memberService.getMemberDetails(memberId);
		
		if(!book.isAvailable()) {
			throw new RuntimeException("Book not available");
		}
		
		Loan loan = Loan.builder()
					.book(book)
					.member(member)
					.loanDate(LocalDate.now())
					.dueDate(LocalDate.now().plusDays(days))
					.returned(false)
					.build();
		
		Loan saved = loanRepo.save(loan);
		
		String msg = "Book with title: '" + loan.getBook().getTitle() + "' borrowed. Due on: " + saved.getDueDate();
//		emailService.send(member.getEmail(), msg);
		sendNotification(member, msg, notify);
		
		return saved;
	}
	
	public Loan returnBook(Long loanId, NotificationType notify) {
		Loan loan = loanRepo.findById(loanId)
				.orElseThrow(() -> new ResourceNotFoundException("Loan Not Found"));
		
		if(loan.isReturned()) throw new RuntimeException("Book already returned");
		
		loan.setReturned(true);
		bookService.markAvailability(loan.getBook().getId(), true);
		
		loanRepo.save(loan);
		
		String msg = "Book: '" + loan.getBook().getTitle() + "' returned";
//		emailService.send(loan.getMember().getEmail(), msg);
		sendNotification(loan.getMember(), msg, notify);
		return loan;
	}
	
	private void sendNotification(Member member, String message, NotificationType type) {
//		switch(type) {
//		case EMAIL -> emailService.send(member.getEmail(), message);
//		case SMS -> smsService.send(member.getPhone(), message);
//		}
		
		NotificationService notify = factory.getService(type);
		String recipient = (type == NotificationType.SMS) ? member.getPhone() : member.getEmail();
		notify.send(recipient, message);
	}
}
