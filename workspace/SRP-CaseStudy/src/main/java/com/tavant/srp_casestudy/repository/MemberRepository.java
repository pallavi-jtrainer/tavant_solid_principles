package com.tavant.srp_casestudy.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.srp_casestudy.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

	Optional<Member> findByEmail(String email);
}
