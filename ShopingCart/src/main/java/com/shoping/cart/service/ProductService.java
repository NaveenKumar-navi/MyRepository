package com.shoping.cart.service;

import java.util.List;

import com.shoping.cart.bean.Product;

public interface ProductService {

	List<Product> getProducts();

	void saveProduct(Product request);

}
