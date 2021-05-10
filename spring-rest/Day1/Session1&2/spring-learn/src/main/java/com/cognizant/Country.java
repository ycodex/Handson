package com.cognizant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	private String code;
	private String name;

	public Country() {
		super();
	}

	public Country(String code, String name) {
		super();
		LOGGER.info("Inside country construcor");
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		LOGGER.info("Inside getCode");
		return code;
	}

	public void setCode(String code) {
		LOGGER.info("Inside setCode");
		this.code = code;
	}

	public String getName() {
		LOGGER.info("Inside getName");
		return name;
	}

	public void setName(String name) {
		LOGGER.info("Inside setCode");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
