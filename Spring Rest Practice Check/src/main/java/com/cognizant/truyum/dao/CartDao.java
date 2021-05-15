package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	public void addCartItem(String userId, long menuItemId) throws CartEmptyException;

	/**
	 * 
	 * @param userId
	 * @return
	 * @throws CartEmptyException
	 */
	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException;

	/**
	 * 
	 * @param userId
	 * @param menuItemId
	 */
	public void removeCartItem(String userId, long menuItemId);
}
