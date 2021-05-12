package com.cognizant.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.SpringLearnApplication;
import com.cognizant.exception.CountryNotFoundException;
import com.cognizant.model.Country;

@Service
public class CountryService {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public Country getCountry(String code) throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");
		for (Country c : countryList) {

			if (c.getCode().equalsIgnoreCase(code)) {

				return c;
			}
		}
		throw new CountryNotFoundException();

	}
}
