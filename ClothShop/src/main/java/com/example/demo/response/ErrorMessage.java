package com.example.demo.response;

import java.util.Date;
import java.util.List;

public class ErrorMessage {
	  private int statusCode;
	  private Date timestamp;
	  private List<String> errorlist;
	  private String message;
	  private String description;

	  public ErrorMessage(int statusCode, Date timestamp,List<String> errorlist,String message, String description) {
	    this.statusCode = statusCode;
	    this.timestamp = timestamp;
	    this.errorlist = errorlist;
	    this.message = message;
	    this.description = description;
	  }

	  public int getStatusCode() {
	    return statusCode;
	  }

	  public Date getTimestamp() {
	    return timestamp;
	  }

	  public String getMessage() {
	    return message;
	  }

	  public String getDescription() {
	    return description;
	  }

	public List<String> getErrorlist() {
		return errorlist;
	}

	
	}
