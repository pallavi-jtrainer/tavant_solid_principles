package com.tavant.srp_casestudy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.srp_casestudy.entity.Loan;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long>{

	List<Loan> findAllByDueDate(LocalDate due);
}
