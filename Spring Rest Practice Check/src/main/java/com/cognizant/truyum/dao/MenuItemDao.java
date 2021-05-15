package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin() throws CartEmptyException;

	public List<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(MenuItem menuItem) throws CartEmptyException;

	public MenuItem getMenuItem(long menuItemId) throws CartEmptyException;
}
