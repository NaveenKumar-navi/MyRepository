package com.example.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.bean.Product;
import com.example.graphql.bean.ProductType;
import com.example.graphql.repository.ProductTypeRepository;
import com.example.graphql.service.ProductService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class ProductMutation implements GraphQLMutationResolver {
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductTypeRepository typerepo;
	
	public Product addProduct(String productName, String productDescription) {
		Product product = new Product();
		product.setProductName(productName);
		product.setProductDescription(productDescription);
		return productService.saveProduct(product);
	}

	public String deleteProduct(Long id) {
		productService.deleteProductById(id);
		return "Product deleted";
	}
	
	public ProductType addType(String productType) {
		ProductType type = new ProductType();
		type.setProductType(productType);
		return typerepo.save(type);
	}
}

