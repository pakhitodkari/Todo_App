package com.pv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pv.exception.ResponseStatusException;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = ResponseStatusException.class)
	   public ResponseEntity<Object> amountInvalidException(Exception e)
	   {
		   return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	   }
}
