package com.cognizant.spring_learn.service;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn.Country;

@Service
public class CountryService {
	private List<Country> countryList;
	private String countryCode;
	CountryService(){
		//Initializing beans inside the constructor as @Autowired is used
		//for CountryService in CountryController the beans are created at 
		//the startup and cached so when ever the api request hits
		//it does create new beans
		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		countryList=(List<Country>)context.getBean("countryList",List.class);
	}
	public Country getCountry(String code) {	
		for(Country country:countryList) {
			countryCode=country.getCode();
			if(countryCode.equalsIgnoreCase(code)) {
				return country;
			}
		}
		return null;	
		
	}

}
