package com.tavant.srp_casestudy.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tavant.srp_casestudy.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	Optional<Book> findByIsbn(String isbn);
	Optional<List<Book>> findAllByAuthor(String author);
	Optional<List<Book>> findAllByTitle(String title);
	
	@Query("select Book b where b.available = true")
	Optional<List<Book>> findAllByAvailable();
	
	@Modifying
	@Query("update Book b set b.available = :available where b.id = :id")
	int updateBookAvailability(@Param("id") long id, @Param("available") boolean available);
}
