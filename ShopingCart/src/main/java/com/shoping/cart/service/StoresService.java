package com.shoping.cart.service;

import java.util.List;

import com.shoping.cart.bean.Stores;

public interface StoresService {

	List<Stores> getStores();

	void saveStores(Stores request);

}
