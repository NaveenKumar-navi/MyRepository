package com.example.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.bean.Product;
import com.example.graphql.bean.ProductType;
import com.example.graphql.bean.Store;
import com.example.graphql.repository.ProductRepository;
import com.example.graphql.repository.ProductTypeRepository;
import com.example.graphql.repository.StoreRepository;
import com.example.graphql.service.StoreService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class StoreRevoler implements GraphQLQueryResolver{

	@Autowired
	private StoreService storeService;
	
	@Autowired
	private StoreRepository storerepo;
	
	@Autowired
	private ProductRepository productrepo;
	
	@Autowired
	private ProductTypeRepository typerepo;
	
	public Store store(Long id) {
		return storeService.getStoreById(id);
	}
	
	public List<Store> allStores() {
		return storerepo.findAll();
	}
	
	public List<Product> allProducts() {
		return productrepo.findAll();
	}

	public List<ProductType> allProductTypes(){
		return typerepo.findAll();
	}
	
	public List<Store> storesByName(String storeName) {
		return storeService.findByStoreName(storeName);
	}
}
