package com.aadhar.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(NotFoundException.class)
	public Map<String, String> handleException(NotFoundException ex) {
		Map<String, String> map = new HashMap<>();
		map.put("ErrorMessage", ex.getMessage());
		return map;

	}

	// @ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> handleNotFoundEception(UserNotFoundException ex) {
		Map<String, String> er = new HashMap<>();
		er.put("ErrorMessage", ex.getMessage());
		er.put("Localmsg", ex.getLocalizedMessage());
		return er;
		//map.keySet().retainAll(keyList);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<String> handleMissingParameterException(MissingServletRequestParameterException ex) {
		String paramName = ex.getParameterName();
		System.out.println(ex.getBody().getInstance());
		return ResponseEntity.badRequest().body("Required parameter '" + paramName + "' is missing.");
	}

}
