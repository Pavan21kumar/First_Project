package com.assignment.exception;

public class PasswordMissMatchException extends RuntimeException {

	private String message;

	public PasswordMissMatchException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
