package com.tavant.srp_casestudy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.srp_casestudy.dto.BookDto;
import com.tavant.srp_casestudy.dto.MemberDto;
import com.tavant.srp_casestudy.entity.Book;
import com.tavant.srp_casestudy.entity.Member;
import com.tavant.srp_casestudy.mappers.CustomMapper;
import com.tavant.srp_casestudy.services.BookService;
import com.tavant.srp_casestudy.services.LoanService;
import com.tavant.srp_casestudy.services.MemberService;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

	private final BookService bookService;
	private final MemberService memberService;
	private final LoanService loanService;
	
	public LibraryController(BookService bookService, MemberService memberService, LoanService loanService) {
		this.bookService = bookService;
		this.memberService = memberService;
		this.loanService = loanService;
	}
	
	@PostMapping("/books")
	public ResponseEntity<Book> addBook(@RequestBody BookDto dto) {
		return ResponseEntity.ok(bookService.addBook(CustomMapper.bookDtoToBook(dto)));
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> listAllBooks() {
		return ResponseEntity.ok(bookService.listAllBooks());
	}
	
	@PostMapping("/members")
	public ResponseEntity<Member> addMember(@RequestBody MemberDto dto) {
		return ResponseEntity.ok(memberService.createMember(CustomMapper.memberDtoToMember(dto)));
	}
	
}
