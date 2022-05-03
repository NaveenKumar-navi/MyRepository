package com.example.demo.exception;

public class ClothNotfoundException extends RuntimeException {

	  private static final long serialVersionUID = 1L;

	  public ClothNotfoundException(String msg) {
	    super(msg);
	  }
	}
