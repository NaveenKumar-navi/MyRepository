package com.example.graphql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.graphql.bean.Store;
import com.example.graphql.repository.StoreRepository;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storerepo;
	

	@Override
	public Store getStoreById(Long id) {
	
		return storerepo.findById(id).get();
	}

	@Override
	public List<Store> findAll() {
		return storerepo.findAll();
	}

	@Override
	public List<Store> findByStoreName(String storeName) {
		return storerepo.findByStoreName(storeName);
	}

	@Override
	public Store saveCountry(Store store) {
		return storerepo.save(store);
	}

	@Override
	public void deleteStoreById(Long id) {
		storerepo.deleteById(id);
		
	}
}
