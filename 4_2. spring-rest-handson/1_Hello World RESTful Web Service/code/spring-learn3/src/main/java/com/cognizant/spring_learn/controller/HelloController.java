package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {
	private static final Logger LOGGER=LoggerFactory.getLogger("HelloController.java");
	@GetMapping("/hello")
	
	public String sayHello() {
		LOGGER.info("Before Hello");
		String helloString="Hello World!";
		LOGGER.info("After Hello");
		return helloString;
		
	}
}