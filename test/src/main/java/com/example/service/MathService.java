package com.example.service;

import org.springframework.stereotype.Service;

import com.example.exceptionhandler.BadReqException;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class MathService {
	
	public String mathOperation(String a , String b,String op) {
		
		Integer result=0;
		Integer x=0;
		Integer y=0;	
		
		if(StringUtils.isEmpty(a) || StringUtils.isEmpty(b) || StringUtils.isBlank(a)
				|| StringUtils.isBlank(b) ) {
			throw new BadReqException("Operands cannot be empty or blank or null");
		}		
	
		try {
			x = Integer.parseInt(a);
			y = Integer.parseInt(b);			
		} 
		catch(NumberFormatException e) {
			throw new BadReqException("This operation supports only integers.");
		}
		if (op.equals("add")) {
			result = x+y;
		} 
		else if (op.equals("diff")) {
			if (x < y) {
				throw new BadReqException("Operand 1 should be greater than Operand 2.");
			}
				
			result = x-y;					
		}
		return  result.toString();
	}
}
