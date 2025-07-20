package com.cognizant.loan.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
	private static final Logger LOGGER=LoggerFactory.getLogger("LoanController.java");
	
	@GetMapping("/loans/{number}")
	public Map<String,Object> getLoanAccountByNumber(@PathVariable String number){
		LOGGER.info("Inside Loan Controller");
		Map<String,Object> loanAccountMap=new LinkedHashMap<>();
		loanAccountMap.put("number","H00987987972342");
		loanAccountMap.put("type", "car");
		loanAccountMap.put("loan", 400000);
		loanAccountMap.put("emi", 3258);
		loanAccountMap.put("tenure",18);
		
		LOGGER.info("Exiting Loan Controller");
		if(loanAccountMap.get("number").equals(number)) {
			return loanAccountMap;
		}
		else {
			loanAccountMap=new LinkedHashMap<>();
			loanAccountMap.put("Loan Account", "No Such Loan Account Found");
			return loanAccountMap;
		}
		
	}
}
