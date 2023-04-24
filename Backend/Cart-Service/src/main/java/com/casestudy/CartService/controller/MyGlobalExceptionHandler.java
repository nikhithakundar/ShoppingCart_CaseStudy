package com.casestudy.CartService.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.casestudy.CartService.entity.ErrorResponse;
import com.casestudy.CartService.exception.CartNotFoundException;

@RestControllerAdvice

public class MyGlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(MyGlobalExceptionHandler.class);

    @ExceptionHandler(value = {CartNotFoundException.class})
    public ErrorResponse cartNotFoundException(CartNotFoundException cx) {

        logger.error(cx.getMessage());
        ErrorResponse error = new ErrorResponse();
        error.setStatusmessage(HttpStatus.NOT_FOUND);
        error.setDatetime(LocalDateTime.now());
        error.setMessage(cx.getMessage());
        return error;
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class})
    public ErrorResponse methodtNotSupport(HttpRequestMethodNotSupportedException ex) {

        logger.error(ex.getMessage());
        ErrorResponse error=new ErrorResponse();
        error.setStatusmessage(HttpStatus.METHOD_NOT_ALLOWED);
        error.setDatetime(LocalDateTime.now());
        error.setMessage(ex.getMessage());
        return error;

    }

      @ExceptionHandler(value = {Exception.class}) 
      public ErrorResponse handleException(Exception ex) {

      logger.error(ex.getMessage());
      ErrorResponse error=new ErrorResponse();
      error.setStatusmessage(HttpStatus.BAD_REQUEST);
      error.setDatetime(LocalDateTime.now());
      error.setMessage(ex.getMessage());
      return error;

      }

 

}

