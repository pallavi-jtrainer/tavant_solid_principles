package com.tavant.SRP_Demo.exceptions;

public class InvalidOrderException extends RuntimeException {

	public InvalidOrderException(String msg) {
		super(msg);
	}
}
