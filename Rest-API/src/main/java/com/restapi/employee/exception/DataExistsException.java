package com.restapi.employee.exception;


public class DataExistsException extends RuntimeException {
	
	

    private String message;

    public DataExistsException(String message) {
        super(message);  // important for RuntimeException
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
}
}