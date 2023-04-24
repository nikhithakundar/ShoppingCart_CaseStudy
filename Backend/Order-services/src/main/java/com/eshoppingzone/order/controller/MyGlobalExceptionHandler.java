package com.eshoppingzone.order.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.eshoppingzone.order.entity.ErrorResponse;
import com.eshoppingzone.order.exception.AddressNotFoundException;
import com.eshoppingzone.order.exception.OrdersNotFoundException;


@RestControllerAdvice
public class MyGlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(MyGlobalExceptionHandler.class);
	
	@ExceptionHandler(value = {OrdersNotFoundException.class})
	public ErrorResponse ordersNotFoundException(OrdersNotFoundException ox) {
		
		logger.error(ox.getMessage());
		
		ErrorResponse error = new ErrorResponse();
		error.setStatusmessage(HttpStatus.NOT_FOUND);
		error.setMessage(ox.getMessage());
		error.setDatetime(LocalDateTime.now());
		return error;
	}
	
	@ExceptionHandler(value = {AddressNotFoundException.class})
	public ErrorResponse addressNotFoundException(AddressNotFoundException ad) {
		ErrorResponse error = new ErrorResponse();
		error.setStatusmessage(HttpStatus.NOT_FOUND);
		error.setMessage(ad.getMessage());
		error.setDatetime(LocalDateTime.now());
		return error;
	}

	
	@ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
	public ErrorResponse methodtNotSupport(HttpRequestMethodNotSupportedException ex) {
		
		ErrorResponse error=new ErrorResponse();
		error.setStatusmessage(HttpStatus.METHOD_NOT_ALLOWED);
		error.setDatetime(LocalDateTime.now());
		error.setMessage(ex.getMessage());
		return error;
		
	}
	
	
	  @ExceptionHandler(value = {Exception.class}) 
	  public ErrorResponse handleException(Exception ex) {
	  
	  ErrorResponse error=new ErrorResponse();
	  error.setStatusmessage(HttpStatus.BAD_REQUEST);
	  error.setDatetime(LocalDateTime.now());
	  error.setMessage(ex.getMessage());
	  return error;
	  
	  }
	 
		
	}

