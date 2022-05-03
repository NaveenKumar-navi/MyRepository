package com.shoping.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoping.cart.bean.Stores;
import com.shoping.cart.repository.StoresRepository;
import com.shoping.cart.service.StoresService;

@Service
public class StoresServiceImpl implements StoresService {

	@Autowired
	private StoresRepository repository;

	@Override
	public List<Stores> getStores() {

		return repository.findAll();
	}

	@Override
	public void saveStores(Stores request) {

		repository.save(request);
	}
}
