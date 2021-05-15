package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImpl() {
//		super();
//		if (menuItemList == null) {
//			menuItemList = new ArrayList<MenuItem>();
//			MenuItem menuItem;
//
//			menuItem = new MenuItem(1, "Sandwich", 99f, true, DateUtil.convertToDate("15/03/2017"), "Main Course",
//					true);
//			menuItemList.add(menuItem);
//			menuItem = new MenuItem(2, "Burger", 129f, true, DateUtil.convertToDate("23/12/2017"), "Main Course",
//					false);
//			menuItemList.add(menuItem);
//			menuItem = new MenuItem(3, "Pizza", 149f, true, DateUtil.convertToDate("21/08/2018"), "Main Course", false);
//			menuItemList.add(menuItem);
//			menuItem = new MenuItem(4, "French Fries", 57f, false, DateUtil.convertToDate("02/07/2017"), "Starters",
//					true);
//			menuItemList.add(menuItem);
//			menuItem = new MenuItem(5, "Chocolate Brownie", 32f, true, DateUtil.convertToDate("02/11/2022"), "Dessert",
//					true);
//			menuItemList.add(menuItem);
//		}
		ApplicationContext ctx = new ClassPathXmlApplicationContext("truyum.xml");
		ArrayList<MenuItem> menuItems = (ArrayList<MenuItem>) ctx.getBean("menuList");
		menuItemList = menuItems;
	}

	public List<MenuItem> getMenuItemListAdmin() throws CartEmptyException {
		if (menuItemList == null) {
			throw new CartEmptyException("Menu List Empty");
		}
		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> customerMenuItemList = new ArrayList<MenuItem>();

		for (int i = 0; i < menuItemList.size(); i++) {
			MenuItem menuItem = menuItemList.get(i);
			if ((menuItem.getDateOfLaunch().equals(new Date()) || menuItem.getDateOfLaunch().before(new Date()))
					&& menuItem.isActive()) {
				customerMenuItemList.add(menuItem);
			}
		}

		return customerMenuItemList;
	}

	public void modifyMenuItem(MenuItem menuItem) throws CartEmptyException {
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).equals(menuItem)) {
				menuItemList.set(i, menuItem);
				break;
			}
		}
		throw new CartEmptyException("Something went Wrong");
	}

	public MenuItem getMenuItem(long menuItemId) throws CartEmptyException {
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		if (menuItem == null) {
			throw new CartEmptyException("Menu Item Id not found");
		}
		return menuItem;
	}

}
