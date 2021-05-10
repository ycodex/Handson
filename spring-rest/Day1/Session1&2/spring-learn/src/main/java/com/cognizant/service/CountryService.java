package com.cognizant.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.Country;
import com.cognizant.CountryNotFoundException;

@Service
public class CountryService {
	public Country getCountry(String code) throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");

		ArrayList<Country> countryList = (ArrayList<Country>) context.getBean("countryList");
		for (Country c : countryList) {
			if (c.getCode().equalsIgnoreCase(code)) {
				return c;
			} else {
				throw new CountryNotFoundException();
			}
		}
		return null;

	}
}
