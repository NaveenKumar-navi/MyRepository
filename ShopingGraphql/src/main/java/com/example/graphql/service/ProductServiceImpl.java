package com.example.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.bean.Product;
import com.example.graphql.repository.ProductRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productrepo;
	
	@Override
	public Product getProductById(Long id) {
		
		return productrepo.findById(id).orElse(null);
	}

	@Override
	public void deleteProductById(Long id) {
		productrepo.deleteById(id);
		
	}

	@Override
	public List<Product> findAll() {
		return productrepo.findAll();
	}

	@Override
	public List<Product> findByProductName(String productName) {
		return productrepo.findByProductName(productName);
	}

	@Override
	public Product saveProduct(Product product) {
		return productrepo.save(product);
	}


}
