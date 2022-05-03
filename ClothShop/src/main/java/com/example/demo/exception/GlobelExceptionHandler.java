package com.example.demo.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.response.ErrorMessage;

@ControllerAdvice
public class GlobelExceptionHandler {
	@ControllerAdvice
	public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
		
		
		@ExceptionHandler(ClothNotfoundException.class)
		public ResponseEntity<?> resourceNotFoundException(ClothNotfoundException ex, WebRequest request) {
			
			 List<String> errorlist = new ArrayList<>();
			    errorlist.add(ex.getLocalizedMessage());
			ErrorMessage errormessage = new ErrorMessage(
			        HttpStatus.NOT_FOUND.value(),
			        new Date(),
			        errorlist,
			        ex.getMessage(),
			        request.getDescription(false));
			    
			    return new ResponseEntity<ErrorMessage>(errormessage,HttpStatus.NOT_FOUND);
			  }
		

		@ExceptionHandler(Exception.class)
		public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
			List<String> errorlist = new ArrayList<>();
		    errorlist.add(ex.getMessage());
			ErrorMessage errormessage = new ErrorMessage(
			        HttpStatus.METHOD_NOT_ALLOWED.value(),
			        new Date(),
			        errorlist,
			        ex.getMessage(),
			        request.getDescription(false));
			    
			    return new ResponseEntity<ErrorMessage>(errormessage, HttpStatus.METHOD_NOT_ALLOWED);
		}
		
		@Override
		  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		      HttpHeaders headers, HttpStatus status, WebRequest request) {
			
			List<String> errorlist = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.toList());
		
			ValidationHandler errorDetails = new ValidationHandler(
					new Date(),
					errorlist,
					"Validation Failed");
//		    ErrorMessage errorDetails = new ErrorMessage(
//		    		HttpStatus.BAD_REQUEST.value(),
//		    		new Date(),
//		    		errorlist,
//		    		ex.getMessage(),
//		        request.getDescription(false));
		    return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
		  } 
	}
}