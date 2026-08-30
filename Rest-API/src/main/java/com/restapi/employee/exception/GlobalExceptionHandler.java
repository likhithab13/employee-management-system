package com.restapi.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.restapi.employee.dto.ErrorDto;

@RestControllerAdvice          //A shortcut annotation that combines @ControllerAdvice with @ResponseBody, in effect simply an @ControllerAdvice whose exception handler methods render to the response body
public class GlobalExceptionHandler {
	@ExceptionHandler(DataExistsException.class)
	@ResponseStatus(value = HttpStatus.CONFLICT)
	public ErrorDto handle(DataExistsException exception) {
		return new ErrorDto(exception.getMessage());
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ErrorDto handle(DataNotFoundException exception) {
		return new ErrorDto(exception.getMessage());
	}
	
	
	
	

}