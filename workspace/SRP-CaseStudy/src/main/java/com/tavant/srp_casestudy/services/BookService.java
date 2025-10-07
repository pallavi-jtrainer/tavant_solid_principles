package com.tavant.srp_casestudy.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.entity.Book;
import com.tavant.srp_casestudy.exceptions.ResourceNotFoundException;
import com.tavant.srp_casestudy.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

	private final BookRepository repo;
	
	public BookService(BookRepository repo) {
		
		this.repo = repo;
	}
	
	public Book addBook(Book book ) {
		return repo.save(book);
	}
	
	public Book getBookDetailsById(long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book with id: " + id + " not found"));
	}
	
	public List<Book> listAllBooks() {
		return repo.findAll();
	}
	
	public Optional<Book> getBookByIsbn(String isbn) {
		return Optional.of(repo.findByIsbn(isbn)
				.orElseThrow(() -> new ResourceNotFoundException("Book with isbn: " + isbn + " not found")));
	}
	
	@Transactional
	public String markAvailability(long id, boolean available) {
		String msg = "Unable to update Book availability";
		
		Book b = getBookDetailsById(id);
		
		if(b != null) {
			int res = repo.updateBookAvailability(id, available);
			if(res > 0) {
				msg = "Book availability updated";
			}
		}
		
		return msg;
	}
}
