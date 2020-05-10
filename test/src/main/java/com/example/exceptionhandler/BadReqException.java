package com.example.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadReqException extends RuntimeException {
	
	public BadReqException(String msg) {
		super(msg);
	}
}
