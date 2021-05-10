package com.cognizant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
//		displayDate();
//		displayCountry();
//		displayCountries();
	}

	public static void displayDate() throws ParseException {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		LOGGER.debug(("" + format.parse("31/12/2018") + ""));
		LOGGER.info("END");
	}

	public static void displayCountry() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("in", Country.class);
		Country anotherCountry = context.getBean("us", Country.class);
		LOGGER.debug("Country : {}", country.toString());
	}

	public static void displayCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List country = (List) context.getBean("countryList");
		LOGGER.debug("Country : {}", country.toString());
	}
}
