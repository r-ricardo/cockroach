package com.test;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpExceptionHandler {

	@ExceptionHandler(HttpNotFoundException.class)
	public ResponseEntity<Void> httpNotFound() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
}
