package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER=LoggerFactory.getLogger("BookService.java");
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);

		LOGGER.info("{}: Main is running");
		display();
		
	}
	public static void display() {
		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		Country country=(Country) context.getBean("country",Country.class);
		//When context.getBean() is invoked the constructor of the country class is called
		//which can be seen in the terminal log info.
		LOGGER.info("Country {}:",country.toString());
		LOGGER.debug("Country {}:",country.toString());
	}

}
