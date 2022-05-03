package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.MAgentCommHierarchy;
import com.example.demo.bean.MAgentCommHierarchyList;
import com.example.demo.dto.ListViewParam;
import com.example.demo.dto.MAgentCommHierarchyListDto;
import com.example.demo.dto.MAgentCommHierarchyMultipleSaveDto;
import com.example.demo.responce.Response;
import com.example.demo.responce.ResponseGenerator;
import com.example.demo.responce.TransactionContext;
import com.example.demo.service.MAgentCommHierarchyService;
import com.example.demo.service.MessagePropertyService;
import com.example.demo.util.ValidationUtil;
import com.example.demo.validator.Convention;
import com.example.demo.validator.MAgentCommHierarchyValidator;
import com.example.demo.validator.ValidationResult;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/magentcommhierarchy")
public class MAgentCommHierarchyController {

	@Autowired
	private MAgentCommHierarchyService entityService;
	private MessagePropertyService messageSource;
	private @NonNull MAgentCommHierarchyValidator validatorService;
	private Convention sorting;

	private static final Logger logger = Logger.getLogger(MAgentCommHierarchyController.class);

	private @NonNull ResponseGenerator responseGenerator;

	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "The Line of Business request payload") @RequestBody MAgentCommHierarchy request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		ValidationResult validationResult = validatorService.validate(request);

		entityService.saveorupdate((MAgentCommHierarchy) validationResult.getObject());

		try {
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}

	}

	@ApiOperation(value = "Allows to fetch all data List.", response = Response.class)
	@GetMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		try {

			List<MAgentCommHierarchy> lst = entityService.getAll();
			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), lst,
					HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@PostMapping(value = "/getAll", produces = "application/json")
	public ResponseEntity<?> getAll(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		Pageable paging = sorting.getPaging(request.getOrderBy(), sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));

		try {

			List<MAgentCommHierarchy> obj = new ArrayList<MAgentCommHierarchy>();
			Page<MAgentCommHierarchy> list = null;

			if (ValidationUtil.isEmptyStringArray(request.getOrderBy()) && ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findAll(paging);

			}
			if (!ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findAll(paging);

			}
			if (ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& !ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findSearch(request.getSearch(), paging);

			}

			if (!ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& !ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findSearch(request.getSearch(), paging);

			}

			obj = list.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("data", obj);
			response.put("currentPage", list.getNumber());
			response.put("totalItems", list.getTotalElements());
			response.put("totalPages", list.getTotalPages());

			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);

		} catch (

		Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}
	
	@PostMapping(value = "/multipleSave", produces = "application/json")
	public ResponseEntity<?> multipleCreateOrUpdate(
			@ApiParam(value = "Request payload") @RequestBody MAgentCommHierarchyMultipleSaveDto request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		ValidationResult validationResult = validatorService.validate(request);

		entityService.saveorupdate((MAgentCommHierarchyList) validationResult.getObject());

		try {
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);

		} catch (Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}


@PostMapping(value = "/getByAll", produces = "application/json")
	public ResponseEntity<?> getAllByDistinct(@RequestBody ListViewParam request, @RequestHeader HttpHeaders httpHeader)
			throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		Pageable paging = sorting.getPaging(request.getOrderBy(), sorting.getPageNumber(request.getPageNumber()),
				sorting.getPageSize(request.getPageSize()));

		try {
			List<MAgentCommHierarchyMultipleSaveDto> obj = new ArrayList<MAgentCommHierarchyMultipleSaveDto>();
			List<MAgentCommHierarchyMultipleSaveDto> list1 = null;
			Page<MAgentCommHierarchyListDto> list = null;

			if (ValidationUtil.isEmptyStringArray(request.getOrderBy()) && ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findByAll(paging);
				list1 = entityService.findByValues(paging);

			}
			if (!ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findByAll(paging);
				list1 = entityService.findByValues(paging);

			}
			if (ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& !ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findBySearch(request.getSearch(), paging);
				list1 = entityService.findBySearchValues(request.getSearch(), paging);

			}

			if (!ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& !ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findBySearch(request.getSearch(), paging);
				list1 = entityService.findBySearchValues(request.getSearch(), paging);

			}

			obj = list1;

			Map<String, Object> response = new HashMap<>();
			response.put("data", obj);
			response.put("currentPage", list.getNumber());
			response.put("totalItems", list.getTotalElements());
			response.put("totalPages", list.getTotalPages());

			return responseGenerator.successGetResponse(context, messageSource.getMessage("fetched"), response,
					HttpStatus.OK);

		} catch (

		Exception e) {

			e.printStackTrace();
			logger.error(e.getMessage(), e);
			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

}
