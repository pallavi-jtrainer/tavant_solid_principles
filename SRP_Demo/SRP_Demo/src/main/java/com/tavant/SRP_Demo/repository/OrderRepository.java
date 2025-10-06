package com.tavant.SRP_Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.SRP_Demo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
