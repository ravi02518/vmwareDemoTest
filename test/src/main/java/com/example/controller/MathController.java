package com.example.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.request.MathOpRequestDetails;
import com.example.model.response.MathOpResponse;
import com.example.service.MathService;

@RestController
@RequestMapping("/api")
public class MathController {
	
	@Autowired
	MathService mathService;
	
	 @PostMapping(value = "/add")
  	 public ResponseEntity<MathOpResponse> testAdd(@RequestBody MathOpRequestDetails inputPayload) {			
        String res = mathService.mathOperation(inputPayload.getOp1(), inputPayload.getOp2(),"add");
	    MathOpResponse result = new MathOpResponse();
	    result.setResult(res);	    
		return new ResponseEntity<MathOpResponse>(result, HttpStatus.OK);		
	}
	 
	 @PostMapping(value = "/diff")
  	 public ResponseEntity<MathOpResponse> testDiff(@RequestBody MathOpRequestDetails inputPayload) {	
	    String res = mathService.mathOperation(inputPayload.getOp1(), inputPayload.getOp2(),"diff");
	    MathOpResponse result = new MathOpResponse();
	    result.setResult(res);	    
		return new ResponseEntity<MathOpResponse>(result, HttpStatus.OK);		
	}

}
