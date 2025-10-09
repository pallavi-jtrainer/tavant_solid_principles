package com.tavant.solid_ticketing_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.solid_ticketing_system.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long>{

}
