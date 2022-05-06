package com.example.graphql.service;

import java.util.List;

import com.example.graphql.bean.Product;

public interface ProductService {

	Product getProductById(Long id);

	List<Product> findAll();
	
	List<Product> findByProductName(String productName);

	void deleteProductById(Long id);

	Product saveProduct(Product product);


}
