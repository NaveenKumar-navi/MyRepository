package com.example.demo.controller;

//import java.io.ByteArrayInputStream;
//import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.MPolWordings;
import com.example.demo.dto.ListViewParam;
import com.example.demo.dto.MPolWordingsDto;
//import com.example.demo.responce.Response;
import com.example.demo.responce.ResponseGenerator;
import com.example.demo.responce.TransactionContext;
import com.example.demo.service.MPolWordingsService;
import com.example.demo.service.MessagePropertyService;
import com.example.demo.util.ValidationUtil;
import com.example.demo.validator.Convention;
import com.example.demo.validator.MPolWordingsValidator;
import com.example.demo.validator.ValidationResult;

//import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor(onConstructor_ = { @Autowired })
@RequestMapping("/mpolwordings")
public class MPolWordingsController {

	private static final Logger logger = Logger.getLogger(MPolWordingsController.class);

	@Autowired
	private MPolWordingsService entityService;


	private Convention sorting;
	private @NonNull ResponseGenerator responseGenerator;
	private @NonNull MPolWordingsValidator validatorService;
	private @NonNull MessagePropertyService messageSource;
	
	 @GetMapping(path="/", produces = "application/json")
	    public List<MPolWordings> getEmployees() 
	    {
	        return entityService.getAll();
	    }

	@PostMapping(value = "/createOrUpdate", produces = "application/json")
	public ResponseEntity<?> createOrUpdate(
			@ApiParam(value = "Prod appl feesrequest payload") @RequestBody MPolWordingsDto request,
			@RequestHeader HttpHeaders httpHeader) throws Exception {

		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);

		ValidationResult validationResult = validatorService.validate(request);

		entityService.saveorupdate((MPolWordings) validationResult.getObject());
		try {
			return responseGenerator.successResponse(context, messageSource.getMessage("saved"), HttpStatus.OK);

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

			List<MPolWordings> obj = new ArrayList<MPolWordings>();
			Page<MPolWordings> list = null;

			if (ValidationUtil.isEmptyStringArray(request.getOrderBy()) && ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findAll(request.getCode()[0], paging);

			}
			if (!ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findAll(request.getCode()[0], paging);

			}
			if (ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& !ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findSearch(request.getCode()[0], request.getSearch(), paging);

			}

			if (!ValidationUtil.isEmptyStringArray(request.getOrderBy())
					&& !ValidationUtil.isNull(request.getSearch())) {

				list = entityService.findSearch(request.getCode()[0], request.getSearch(), paging);

			}

			obj = list.getContent();

//			if (obj.isEmpty()) {
//				return responseGenerator.errorResponse(context, messageSource.getMessage("not.found"),
//						HttpStatus.BAD_REQUEST);
//			}

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

//	@ApiOperation(value = "Allows to download manifest excel file.", response = Response.class)
//	@GetMapping(value = "/excelDownload/{prodCode}", produces = "application/json")
//	public ResponseEntity<?> downloadManifestExcelFile(@RequestHeader HttpHeaders httpHeader,
//			@PathVariable("prodCode") String prodCode) throws Exception {
//
//		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
//
//		List<MPolWordings> obj = entityService.findByPwProductCode(prodCode);
//
//		String fileName = "PolWordings_Records.xlsx";
//		try {
//			InputStream excelInputStream = new ByteArrayInputStream(excelService.downloadExcelPolWordings(obj));
//
//			return ResponseEntity.ok().header("Access-Control-Expose-Headers", "Content-Disposition")
//					.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
//					.header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
//					.body(new InputStreamResource(excelInputStream));
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			logger.error(e.getMessage(), e);
//			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);
//		}
//	}

//	@RequestMapping(value = "/upload/{schCode}", method = RequestMethod.POST, produces = "application/json")
//	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,
//			@PathVariable("schCode") String schCode, @RequestHeader HttpHeaders httpHeader) throws Exception {
//		TransactionContext context = responseGenerator.generateTransationContext(httpHeader);
//
//		if (!ValidationUtil.hasExcelFormat(file)) {
//			return responseGenerator.errorResponse(context, "Invalid File Request", HttpStatus.BAD_REQUEST);
//		}
//
//		List<MPolWordings> list = new ArrayList<MPolWordings>();
//
//		list = excelService.uploadExcelConditions(file, schCode);
//
//		try {
//
//			if (list.isEmpty()) {
//				return responseGenerator.successResponse(context, " Uploaded File Successfully", HttpStatus.OK);
//			} else {
//
//				String fileName = "errors.xlsx";
//
//				InputStream excelInputStream = new ByteArrayInputStream(excelService.downloadExcelConditions(list));
//
//				return ResponseEntity.ok().header("Access-Control-Expose-Headers", "Content-Disposition")
//						.contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
//						.header("Content-Disposition", "attachment; filename=\"" + fileName + "\"")
//						.body(new InputStreamResource(excelInputStream));
//
//			}
//
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			logger.error(e.getMessage(), e);
//			return responseGenerator.errorResponse(context, e.getMessage(), HttpStatus.BAD_REQUEST);
//
//		}
//	}

}

