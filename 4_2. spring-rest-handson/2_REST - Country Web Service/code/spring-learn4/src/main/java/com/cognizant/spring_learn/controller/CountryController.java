package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.spring_learn.Country;


@RestController
@RequestMapping("/country")
public class CountryController {
	private static final Logger LOGGER=LoggerFactory.getLogger("CountryController.java");
	@GetMapping()
	public Country getCountry() {
		LOGGER.info("Entering Country Controller");
		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		Country country=(Country) context.getBean("country",Country.class);
		LOGGER.info("Exiting from Country Controller");
		return country;
	}
	/*
	 * The controller method getCountry() is mapped with the URL \country
	 * When a get request is made the getCountry() method executes which creates a county bean
	 * and returns that object from the controller
	 * 
	 * 
	 * The @RestController combines @Controller and response body and returns that value
	 * The return value i.e country object is serialized to JSON using Jackson.
	 * The JSON value is finally sent back to the client as HTTP response.
	 */
	
	

}
