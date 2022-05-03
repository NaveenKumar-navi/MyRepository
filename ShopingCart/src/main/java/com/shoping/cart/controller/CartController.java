package com.shoping.cart.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoping.cart.bean.Cart;
import com.shoping.cart.dto.CartDto;
import com.shoping.cart.response.Response;
import com.shoping.cart.response.ResponseGenerator;
import com.shoping.cart.service.CartService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService service;

	@Autowired
	private @NonNull ResponseGenerator responseGenerator;

	private static final Logger logger = Logger.getLogger(CartController.class);

	@ApiOperation(value = "Create or Update.", response = Response.class)
	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(@ApiParam(value = "Request payload") @Valid @RequestBody Cart request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		service.saveCarts(request);

		try {
			return responseGenerator.successResponse("Data Created Successfully", HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Cart details view.", response = Response.class)
	@GetMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getCartsView() {
		List<CartDto> cart = service.getCartsView();

		try {
			return responseGenerator.successGetResponse("Fetched Data Successfully", cart, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Delete the Cart from your list.", response = Response.class)
	@DeleteMapping(value = "/delete/{cart_id}", produces = "application/json")
	public ResponseEntity<?> deleteCart(@PathVariable("cart_id") Long cart_id) {

		service.deleteLob(cart_id);
		try {

			return responseGenerator.successGetResponse("Cart is deleted successsfully", cart_id, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

}
