package com.cognizant.truyum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
public class MenuItemController {
	@Autowired
	MenuItemService menuItemService;

	/**
	 * 
	 * @return
	 */
	@GetMapping("/menu")
	public List<MenuItem> getAllMenuItems() {
		return menuItemService.getMenuItemListCustomer();
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws CartEmptyException
	 */
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable long id) throws CartEmptyException {
		return menuItemService.getMenuItem(id);
	}

	/**
	 * 
	 * @param menuItem
	 * @throws CartEmptyException
	 */
	@PutMapping()
	public void modifyMenuItem(@RequestBody MenuItem menuItem) throws CartEmptyException {
		menuItemService.modifyMenuItem(menuItem);
	}
}
