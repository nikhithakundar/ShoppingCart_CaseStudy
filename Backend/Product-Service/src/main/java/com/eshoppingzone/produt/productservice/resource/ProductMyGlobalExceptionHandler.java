package com.eshoppingzone.produt.productservice.resource;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eshoppingzone.produt.exception.ProductCategoryNotFoundException;
import com.eshoppingzone.produt.exception.ProductNotFoundException;
import com.eshoppingzone.produt.exception.ProductTypeNotExistsException;
import com.eshoppingzone.produt.productservice.entity.ErrorResponse;



@RestControllerAdvice 
public class ProductMyGlobalExceptionHandler {
    
	private static final Logger logger=LoggerFactory.getLogger(ProductMyGlobalExceptionHandler.class);
	
    @ExceptionHandler (value = {ProductNotFoundException .class})
    public ErrorResponse productNotFound(ProductNotFoundException cx) {
    	
    	logger.error(cx.getMessage());
        ErrorResponse error = new ErrorResponse();
        error.setStatusmessage(HttpStatus.NOT_FOUND);
        error.setDatetime(LocalDateTime.now());
        error.setMessage(cx.getMessage());
        return error;
        
    }
    
    
    @ExceptionHandler (value = {ProductCategoryNotFoundException .class})
    public ErrorResponse productCategoryNotFound(ProductCategoryNotFoundException zx) {
    	
    	logger.error(zx.getMessage());
        ErrorResponse error = new ErrorResponse();
        error.setStatusmessage(HttpStatus.NOT_FOUND);
        error.setDatetime(LocalDateTime.now());
        error.setMessage(zx.getMessage());
        return error;
        
    }
    
    
    
    @ExceptionHandler (value = {ProductTypeNotExistsException .class})
    public ErrorResponse productTypeNotFound(ProductTypeNotExistsException yx) {
    	
    	logger.error(yx.getMessage());
        ErrorResponse error = new ErrorResponse();
        error.setStatusmessage(HttpStatus.NOT_FOUND);
        error.setDatetime(LocalDateTime.now());
        error.setMessage(yx.getMessage());
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

