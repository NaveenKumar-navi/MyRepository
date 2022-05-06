package com.example.graphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.graphql.bean.Product;
import com.example.graphql.bean.Store;
import com.example.graphql.service.ProductService;
import com.example.graphql.service.StoreService;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class StoreMutation implements GraphQLMutationResolver{
	
	@Autowired
	private StoreService storeService;
	
	@Autowired
	private ProductService productService;
	
	public Store addStore(String storeName, String storeDescription) {
		Store store = new Store();
		store.setStoreName(storeName);
		store.setStoreDescription(storeDescription);
		storeService.saveCountry(store);
		return store;
	}

	public Store addStoreWithCapital(String storeName, String storeDescription, Product capital) {
		Store store = new Store();
		store.setStoreName(storeName);
		store.setStoreDescription(storeDescription);
		store = storeService.saveCountry(store);
		Product product = productService.getProductById(capital.getId());
		if (product != null) {
			store.setCapital(product);
		} else {
			store.setCapital(productService.saveProduct(capital));
		}
		return storeService.saveCountry(store);
	}

	public String deleteStore(Long id) {
		storeService.deleteStoreById(id);
		return "Store deleted";
	}
	
	public Store setCapital(Long storeId,Long productId) {
		Store store = storeService.getStoreById(storeId);
		store.setCapital(productService.getProductById(productId));
		return storeService.saveCountry(store);
		
	}
}
