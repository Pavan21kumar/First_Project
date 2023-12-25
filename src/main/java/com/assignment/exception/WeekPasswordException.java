package com.assignment.exception;

public class WeekPasswordException extends RuntimeException {

	String message;

	public WeekPasswordException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
