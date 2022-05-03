package com.shoping.cart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoping.cart.bean.Cart;
import com.shoping.cart.dto.CartDto;
import com.shoping.cart.dto.CartListDto;
import com.shoping.cart.dto.ProductDetails;
import com.shoping.cart.repository.CartRepository;
import com.shoping.cart.repository.ProductDetailsListRepository;
import com.shoping.cart.repository.ProductRepository;
import com.shoping.cart.repository.StoresRepository;
import com.shoping.cart.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository repository;

	@Autowired
	private ProductRepository repo;

	@Autowired
	private ProductDetailsListRepository dtlrepo;

	@Autowired
	private StoresRepository storepo;

	@Override
	public void saveCarts(Cart request) {

		repository.save(request);
	}

	@Override
	public List<CartDto> getCartsView() {

		List<CartDto> obj = new ArrayList<CartDto>();

		List<CartListDto> list = repository.findByAll();

		for (CartListDto data : list) {
			CartDto dataObj = new CartDto();

			dataObj.setStoreId(data.getStoreId());

			dataObj.setStoreName(storepo.findById(data.getStoreId()).get().getStoreName());

			List<ProductDetails> subList = new ArrayList<ProductDetails>();

			List<Cart> dataList = repository.findByStoreId(data.getStoreId());

			for (Cart agentData : dataList) {
				ProductDetails subData = new ProductDetails();

				subData.setCartid(agentData.getCart_id());
				subData.setProductId(agentData.getProductId());

				subData.setProductName(repo.getById(agentData.getProductId()).getProductName());
				subData.setProductDetailId(agentData.getProductDtlId());
				subData.setColor(dtlrepo.getById(agentData.getProductDtlId()).getColor());
				subData.setSize(dtlrepo.getById(agentData.getProductDtlId()).getSize());
				subData.setQuantity(dtlrepo.getById(agentData.getProductDtlId()).getQuantity());
				subData.setSalesRate(dtlrepo.getById(agentData.getProductDtlId()).getSalesRate());
				subData.setOfferRate(dtlrepo.getById(agentData.getProductDtlId()).getOfferRate());
				subList.add(subData);

			}
			dataObj.setProductDetails(subList);
			obj.add(dataObj);

		}

		return obj;
	}

	@Override
	public void deleteLob(Long cart_id) {

		repository.deleteById(cart_id);

	}

}
