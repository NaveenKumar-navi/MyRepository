package com.example.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.bean.Product;
import com.example.graphql.service.ProductService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class ProductResolver implements GraphQLQueryResolver {

	@Autowired
	private ProductService cityService;

	public Product product(Long id) {
		return cityService.getProductById(id);
	}

//	public List<Product> allProducts() {
//		return cityService.findAll();
//	}

	public List<Product> productsByName(String productName) {
		return cityService.findByProductName(productName);
	}

}
