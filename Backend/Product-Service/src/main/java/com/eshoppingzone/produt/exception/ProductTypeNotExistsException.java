package com.eshoppingzone.produt.exception;

public class ProductTypeNotExistsException extends RuntimeException{

	public ProductTypeNotExistsException() {
		super();
	}

	public ProductTypeNotExistsException(String message) {
		super(message);
	}

	public ProductTypeNotExistsException(Throwable cause) {
		super(cause);
	}

	
}

