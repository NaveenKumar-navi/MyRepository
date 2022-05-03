package com.shoping.cart.response;

import java.util.Date;
import java.util.List;

public class ErrorMessage {
	private int statusCode;
	private Date timestamp;
	private List<String> errorlist;
	private List<String> message;
	private String description;

	public ErrorMessage(int statusCode, Date timestamp, List<String> errorlist, List<String> messagelist,
			String description) {
		this.statusCode = statusCode;
		this.timestamp = timestamp;
		this.errorlist = errorlist;
		this.message = messagelist;
		this.description = description;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public List<String> getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public List<String> getErrorlist() {
		return errorlist;
	}

}
