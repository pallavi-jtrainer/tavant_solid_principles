package com.tavant.srp_casestudy.mappers;

import java.time.LocalDate;

import com.tavant.srp_casestudy.dto.BookDto;
import com.tavant.srp_casestudy.dto.LoanDto;
import com.tavant.srp_casestudy.dto.MemberDto;
import com.tavant.srp_casestudy.entity.Book;
import com.tavant.srp_casestudy.entity.Loan;
import com.tavant.srp_casestudy.entity.Member;

public class CustomMapper {

	//Book
	public static Book bookDtoToBook(BookDto dto) {
		if(dto == null) return null;
		
		return Book.builder()
				.title(dto.getTitle())
				.author(dto.getAuthor())
				.isbn(dto.getIsbn())
				.available(true)
				.build();
	}
	
	public static BookDto bookToBookDto(Book book) {
		BookDto dto = new BookDto();
		dto.setTitle(book.getTitle());
		dto.setAuthor(book.getAuthor());
		dto.setIsbn(book.getIsbn());
		
		return dto;
	}
	
	//Member
	public static Member memberDtoToMember(MemberDto dto) {
		if(dto == null) return null;
		
		Member m = new Member();
		m.setFirstName(dto.getFirstName());
		m.setLastName(dto.getLastName());
		m.setEmail(dto.getEmail());
		
		return m;
	} 
	
	public static MemberDto memberToMemberDto(Member member) {
		MemberDto dto = new MemberDto();
		dto.setFirstName(member.getFirstName());
		dto.setLastName(member.getLastName());
		dto.setEmail(member.getEmail());
		
		return dto;
	}
	
	//Loan
	public Loan loanDtoToLoan(LoanDto dto, Book book, Member member) {
		if(dto == null || book == null || member == null) return null;
		
		Loan l = new Loan();
		
		l.setBook(book);
		l.setMember(member);
		l.setLoanDate(LocalDate.now());
		l.setDueDate(LocalDate.now().plusDays(dto.getLoanDays()));
		l.setReturned(false);
		
		return l;
	}
}
