package com.restapi.employee.dto;

public class ErrorDto {
	
	public ErrorDto(String error) {
		super();
		this.error = error;
	}

	private String error;

	public String getError() {
		return error;
	}

}