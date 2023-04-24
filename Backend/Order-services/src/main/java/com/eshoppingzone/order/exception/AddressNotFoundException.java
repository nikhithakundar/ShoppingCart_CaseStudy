package com.eshoppingzone.order.exception;

public class AddressNotFoundException extends RuntimeException {

	public AddressNotFoundException() {
		super();
		
	}
	public AddressNotFoundException(String message) {
		super(message);
	}

	public AddressNotFoundException(Throwable cause) {
		super(cause);
	}

}
