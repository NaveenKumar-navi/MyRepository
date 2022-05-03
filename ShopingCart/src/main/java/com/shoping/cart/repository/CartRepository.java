package com.shoping.cart.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shoping.cart.bean.Cart;
import com.shoping.cart.dto.CartListDto;

public interface CartRepository extends JpaRepository<Cart, Long> {

	@Query(value = "select distinct store_id as storeId from cart", nativeQuery = true)
	List<CartListDto> findByAll();

	List<Cart> findByStoreId(Long storeId);

}
