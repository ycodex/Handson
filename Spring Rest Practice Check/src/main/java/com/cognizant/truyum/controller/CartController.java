package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	CartService cartService;
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@PathVariable String userId, @PathVariable long menuItemId) {
		cartService.addCartItem(userId, menuItemId);
	}

	@GetMapping("/{userId}")
	public List<MenuItem> getcartItems(@PathVariable String userId) throws CartEmptyException {
		return cartService.getAllCartItems(userId);
	}

	@DeleteMapping("/{userId}/{menuItemId}")
	public void deleteCartItem(@PathVariable String userId, @PathVariable long menuItemId) {
		LOGGER.info("inside controller");
		cartService.deleteCartItems(userId, menuItemId);
	}
}
