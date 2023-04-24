package com.eshoppingzone.produt.exception;

public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException() {
		super();
		
	}

	public ProductNotFoundException(String message) {
		super(message);
		
	}

	public ProductNotFoundException(Throwable cause) {
		super(cause);
	}

	
	
}
