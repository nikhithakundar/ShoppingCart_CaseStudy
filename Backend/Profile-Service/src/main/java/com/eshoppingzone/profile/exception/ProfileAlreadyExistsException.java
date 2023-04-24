package com.eshoppingzone.profile.exception;

public class ProfileAlreadyExistsException extends RuntimeException {

	public ProfileAlreadyExistsException() {
		super();
	}

	public ProfileAlreadyExistsException(String message) {
		super(message);
	}

	public ProfileAlreadyExistsException(Throwable cause) {
		super(cause);
	
	}


}
