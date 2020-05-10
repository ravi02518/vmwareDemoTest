package com.example.exceptionhandler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  
	@ExceptionHandler(value = BadReqException.class)
	public ResponseEntity<Object> badRequest(BadReqException exception) {
		  ErrorResponse response = new ErrorResponse();
		  response.setMessage(exception.getLocalizedMessage());
		  response.setError(HttpStatus.BAD_REQUEST);
		  response.setStatus(400);		
		  response.setTimestamp(LocalDateTime.now());
	      return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	   }
}
