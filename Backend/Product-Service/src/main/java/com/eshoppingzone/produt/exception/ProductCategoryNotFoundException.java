package com.eshoppingzone.produt.exception;

public class ProductCategoryNotFoundException extends RuntimeException {

	public ProductCategoryNotFoundException() {
		super();
	}

	public ProductCategoryNotFoundException(String message) {
		super(message);	
	}

	public ProductCategoryNotFoundException(Throwable cause) {
		super(cause);
	}

		

}

