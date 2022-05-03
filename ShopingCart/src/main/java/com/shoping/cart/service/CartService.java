package com.shoping.cart.service;

import java.util.List;

import com.shoping.cart.bean.Cart;
import com.shoping.cart.dto.CartDto;

public interface CartService {

	void saveCarts(Cart request);

	List<CartDto> getCartsView();

	void deleteLob(Long cart_id);
}
