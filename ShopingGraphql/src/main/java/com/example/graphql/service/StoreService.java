package com.example.graphql.service;

import java.util.List;

import com.example.graphql.bean.Store;

public interface StoreService {

	Store getStoreById(Long id);

	List<Store> findAll();

	List<Store> findByStoreName(String storeName);

	Store saveCountry(Store store);

	void deleteStoreById(Long id);
}
