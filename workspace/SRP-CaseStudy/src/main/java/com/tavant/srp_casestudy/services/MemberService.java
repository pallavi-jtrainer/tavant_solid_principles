package com.tavant.srp_casestudy.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tavant.srp_casestudy.entity.Member;
import com.tavant.srp_casestudy.exceptions.ResourceNotFoundException;
import com.tavant.srp_casestudy.repository.MemberRepository;

@Service
public class MemberService {

	private final MemberRepository repo;

	public MemberService(MemberRepository repo) {
		this.repo = repo;
	}
	
	public Member createMember(Member m) {
		return repo.save(m);
	}
	
	public List<Member> listAllMembers() {
		return repo.findAll();
	}
	
	public Member getMemberDetails(long id) {
		return repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Member with id: "+ id + " not found"));
	}
	
	public Member getMemberByEmail(String email) {
		return repo.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("Member with email: "+ email + " not found"));
	}
}
