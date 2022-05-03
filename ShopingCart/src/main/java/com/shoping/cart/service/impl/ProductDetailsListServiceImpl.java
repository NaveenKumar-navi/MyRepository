package com.shoping.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoping.cart.bean.ProductDetailsList;
import com.shoping.cart.repository.ProductDetailsListRepository;
import com.shoping.cart.service.ProductDetailsListService;

@Service
public class ProductDetailsListServiceImpl implements ProductDetailsListService {

	@Autowired
	private ProductDetailsListRepository repository;

	@Override
	public List<ProductDetailsList> getDetails() {

		return repository.findAll();
	}

	@Override
	public void saveProductDetails(ProductDetailsList request) {

		repository.save(request);
	}

}
