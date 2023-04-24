package com.eshoppingzone.profile.exception;

public class ProfileNotFoundException extends RuntimeException {

	public ProfileNotFoundException() {
		super();
	}

	public ProfileNotFoundException(String message) {
		super(message);
		}

	public ProfileNotFoundException(Throwable cause) {
		super(cause);
	}  

}
