package com.shoping.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoping.cart.bean.ProductType;
import com.shoping.cart.repository.ProductTypeRepository;
import com.shoping.cart.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository repository;

	@Override
	public List<ProductType> getCustomers() {

		return repository.findAll();
	}

	@Override
	public void saveProductType(ProductType request) {

		repository.save(request);
	}

}
