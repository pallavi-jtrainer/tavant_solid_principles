package com.tavant.SRP_Demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.SRP_Demo.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
