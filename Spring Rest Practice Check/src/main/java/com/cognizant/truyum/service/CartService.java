package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {
	@Autowired
	CartDaoCollectionImpl cartDaoCollectionImpl;
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	public void addCartItem(String userId, long menuItemId) {
		cartDaoCollectionImpl.addCartItem(userId, menuItemId);
	}

	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		return cartDaoCollectionImpl.getAllCartItems(userId);
	}

	public void deleteCartItems(String userId, long menuItemId) {
		LOGGER.info("inside Service");
		cartDaoCollectionImpl.removeCartItem(userId, menuItemId);
	}
}
