package com.shoping.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoping.cart.bean.Product;
import com.shoping.cart.repository.ProductRepository;
import com.shoping.cart.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<Product> getProducts() {

		return repository.findAll();
	}

	@Override
	public void saveProduct(Product request) {

		repository.save(request);
	}

}
