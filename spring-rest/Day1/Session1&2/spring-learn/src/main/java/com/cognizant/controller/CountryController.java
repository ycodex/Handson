package com.cognizant.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Country;
import com.cognizant.CountryNotFoundException;
import com.cognizant.SpringLearnApplication;
import com.cognizant.service.CountryService;

@RestController
public class CountryController {
	@Autowired
	CountryService service;
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public CountryController(CountryService service) {
		super();
		this.service = service;
		LOGGER.info("Inside Country Controller");
	}

	@RequestMapping(value = "/country")
	public Country getCountryIndia() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		Country country = (Country) context.getBean("in", Country.class);
		return country;
	}

	@GetMapping("/countries")
	public List<Country> getAllCountries() {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		List countryList = (List) context.getBean("countryList");
		return countryList;
	}

	@GetMapping("/country/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		return service.getCountry(code);
	}
}
