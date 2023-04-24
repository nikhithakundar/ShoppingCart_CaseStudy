package com.eshoppingzone.profile.userprofileservice.resource;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eshoppingzone.profile.exception.ProfileAlreadyExistsException;
import com.eshoppingzone.profile.exception.ProfileNotFoundException;
import com.eshoppingzone.profile.userprofileservice.pojo.ErrorResponse;


@RestControllerAdvice
public class MyGlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(MyGlobalExceptionHandler.class);

	@ExceptionHandler(value = { ProfileNotFoundException.class })
	public ErrorResponse profileNotFound(ProfileNotFoundException cx) {

		logger.error(cx.getMessage());
		ErrorResponse error = new ErrorResponse();
		error.setStatusmessage(HttpStatus.NOT_FOUND);
		error.setDatetime(LocalDateTime.now());
		error.setMessage(cx.getMessage());
		return error;

	}

	@ExceptionHandler(value = { HttpMessageNotReadableException.class })
	public ErrorResponse handleException1(HttpMessageNotReadableException ex) {

		ErrorResponse error = new ErrorResponse();
		error.setStatusmessage(HttpStatus.NO_CONTENT);
		error.setDatetime(LocalDateTime.now());
		error.setMessage(ex.getMessage());
		return error;

	}

	@ExceptionHandler(value = { ProfileAlreadyExistsException.class })
	public ErrorResponse profileAlreadyExist(ProfileAlreadyExistsException ax) {
		logger.error(ax.getMessage());
		ErrorResponse error = new ErrorResponse();
		error.setStatusmessage(HttpStatus.ALREADY_REPORTED);
		error.setDatetime(LocalDateTime.now());
		error.setMessage(ax.getMessage());
		return error;
	}

	@ExceptionHandler(value = { HttpRequestMethodNotSupportedException.class })
	public ErrorResponse methodtNotSupport(HttpRequestMethodNotSupportedException ex) {

		ErrorResponse error = new ErrorResponse();
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
