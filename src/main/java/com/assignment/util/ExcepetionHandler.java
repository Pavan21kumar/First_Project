package com.assignment.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assignment.exception.PasswordMissMatchException;
import com.assignment.exception.WeekPasswordException;

@RestControllerAdvice
public class ExcepetionHandler {

	@ExceptionHandler(WeekPasswordException.class)
	public ResponseEntity<String> handlerWeekPasswordException(WeekPasswordException e)
	{
		String message=e.getMessage();
		return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(PasswordMissMatchException.class)
	public ResponseEntity<String> handlerPasswordMissMatchException(PasswordMissMatchException e)
	{
		String message=e.getMessage();
		return new ResponseEntity<String>(message,HttpStatus.BAD_REQUEST);
	}
	
	
}
