package com.training.exceptions;

/*
 *  This is a checked exception since it is extending the Exception class
 *  If it had extended RuntimeException, then it would have been unchecked exception
 */

public class RangeCheckException extends Exception {
	
	private String errorCode;

	private String message;
	
	public RangeCheckException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	@Override
	public String getMessage() {
		return this.errorCode+":"+super.getMessage();
	}
	
	
	
}
