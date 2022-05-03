package com.shoping.cart.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoping.cart.bean.Product;
import com.shoping.cart.response.Response;
import com.shoping.cart.response.ResponseGenerator;
import com.shoping.cart.service.ProductService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.NonNull;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@Autowired
	private @NonNull ResponseGenerator responseGenerator;

	private static final Logger logger = Logger.getLogger(ProductController.class);

	@ApiOperation(value = "Product details view.", response = Response.class)
	@GetMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getProducts() {
		List<Product> product = service.getProducts();

		try {
			return responseGenerator.successGetResponse("Fetched Data Successfully", product, HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@ApiOperation(value = "Create Or Update.", response = Response.class)
	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(@ApiParam(value = "Request payload") @Valid @RequestBody Product request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		service.saveProduct(request);

		try {
			return responseGenerator.successResponse("Data Created Successfully", HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
}
