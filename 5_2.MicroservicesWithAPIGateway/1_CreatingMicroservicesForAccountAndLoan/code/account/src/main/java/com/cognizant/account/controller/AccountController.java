package com.cognizant.account.controller;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class AccountController {
	private static final Logger LOGGER=LoggerFactory.getLogger("AccountController.java");
	
	
	@GetMapping("/accounts/{number}")
	public Map<String,Object> getAccountByNumber(@PathVariable String number){
		LOGGER.info("Inside Account Controller");
		List <Map <String,Object>> accounts=new ArrayList<>();
		Map <String,Object>accountMap=new LinkedHashMap<>();
		
		accountMap.put("number","00987987973432");
		accountMap.put("type", "savings");
		accountMap.put("balance", 234343);
		
		accounts.add(accountMap);
		accountMap=new LinkedHashMap<>();
		accountMap.put("number","00987983453432");
		accountMap.put("type", "current");
		accountMap.put("balance", 456299);
		
		LOGGER.info("Exiting Account Controller");
		for(Map <String,Object> map: accounts) {
			if(map.get("number").equals(number))
				return map;
		}
		accountMap=new LinkedHashMap<>();
		accountMap.put("account", "No such Account Found");
		return accountMap;
	}

}
