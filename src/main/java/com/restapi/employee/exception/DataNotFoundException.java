package com.restapi.employee.exception;

public class DataNotFoundException extends RuntimeException {
	

	public DataNotFoundException(String message) {
		super();
		this.message = message;
	}

	private String message;

	public String getMessage() {
		return message;
	}
	

}