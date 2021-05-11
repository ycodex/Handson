package com.cognizant.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.SpringLearnApplication;

@RestController
public class HelloController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("Inside sayHello");
		return "Hello World!!";
	}

}
