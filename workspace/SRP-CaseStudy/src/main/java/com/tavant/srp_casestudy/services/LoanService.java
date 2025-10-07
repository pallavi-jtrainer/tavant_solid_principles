package com.tavant.srp_casestudy.services;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.entity.Book;
import com.tavant.srp_casestudy.entity.Loan;
import com.tavant.srp_casestudy.entity.Member;
import com.tavant.srp_casestudy.exceptions.ResourceNotFoundException;
import com.tavant.srp_casestudy.repository.LoanRepository;
import com.tavant.srp_casestudy.services.impl.EmailNotificationService;


@Service
public class LoanService {

	private final LoanRepository loanRepo;
	private final BookService bookService;
	private final MemberService memberService;
	private final EmailNotificationService emailService;
	
	public LoanService(LoanRepository loanRepo, BookService bookService, MemberService memberService,
			EmailNotificationService emailService) {
		this.loanRepo = loanRepo;
		this.bookService = bookService;
		this.memberService = memberService;
		this.emailService = emailService;
	}
	
	public Loan loanBook(Long bookId, Long memberId, int days) {
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
		emailService.send(member.getEmail(), msg);
		
		return saved;
	}
	
	public Loan returnBook(Long loanId) {
		Loan loan = loanRepo.findById(loanId)
				.orElseThrow(() -> new ResourceNotFoundException("Loan Not Found"));
		
		if(loan.isReturned()) throw new RuntimeException("Book already returned");
		
		loan.setReturned(true);
		bookService.markAvailability(loan.getBook().getId(), true);
		
		loanRepo.save(loan);
		
		String msg = "Book: '" + loan.getBook().getTitle() + "' returned";
		emailService.send(loan.getMember().getEmail(), msg);
		
		return loan;
	}
	
	
}
