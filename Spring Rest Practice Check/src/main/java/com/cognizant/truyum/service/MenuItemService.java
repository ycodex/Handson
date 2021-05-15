package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	MenuItemDaoCollectionImpl menuItemDao;

	/**
	 * 
	 * @return
	 */
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws CartEmptyException
	 */
	public MenuItem getMenuItem(long id) throws CartEmptyException {
		return menuItemDao.getMenuItem(id);
	}

	/**
	 * 
	 * @param menuItem
	 * @throws CartEmptyException
	 */
	public void modifyMenuItem(MenuItem menuItem) throws CartEmptyException {
		menuItemDao.modifyMenuItem(menuItem);
	}
}
