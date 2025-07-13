package com.cognizant.spring_learn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.CountryService;


@RestController
@RequestMapping("/countries/{code}")
public class CountryController {
	private static final Logger LOGGER=LoggerFactory.getLogger("CountryController.java");
	@Autowired
	private CountryService countryService;
	private Country country;
	@GetMapping()
	public Country getCountry(@PathVariable String code) {
		LOGGER.info("Entering Country Controller");
		country=countryService.getCountry(code);
		LOGGER.info("Exiting from Country Controller");
		return country;
	}	

}
