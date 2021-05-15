package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@Repository
public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<String, Cart> userCarts;
	private static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
	}

	public void addCartItem(String userId, long menuItemId) throws CartEmptyException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0.0);
			cart.getMenuItemList().add(menuItem);
			userCarts.put(userId, cart);
		}
		LOGGER.info("Map" + userCarts);
	}

	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		LOGGER.info("Map" + userCarts);
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			if (menuItemList.isEmpty()) {
				throw (new CartEmptyException("No items in Cart"));
			} else {
				double total = 0.0;
				for (int i = 0; i < menuItemList.size(); i++) {
					total += menuItemList.get(i).getPrice();
				}
				userCarts.get(userId).setTotal(total);
			}
			return menuItemList;
		} else {
			throw (new CartEmptyException("No user Found"));
		}

	}

	public void removeCartItem(String userId, long menuItemId) {
		LOGGER.info("inside DAO");
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItemList.remove(i);
				break;
			}
		}
	}

}
