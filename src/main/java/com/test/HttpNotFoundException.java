package com.test;

public class HttpNotFoundException extends RuntimeException {

	private final static long serialVersionUID = 1;
	
	public HttpNotFoundException(String message) {
		super(message);
	}
}
