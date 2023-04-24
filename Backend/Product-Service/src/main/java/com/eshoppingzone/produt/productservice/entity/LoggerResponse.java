package com.eshoppingzone.produt.productservice.entity;

public class LoggerResponse {

	private String message;

	public LoggerResponse() {

	}

	public LoggerResponse(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LoggerResponse [message=" + message + "]";
	}

}

