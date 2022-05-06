package com.example.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.graphql.bean.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

	@Override
	List<Product> findAll();
	
	List<Product> findByProductName(String productName);

}
