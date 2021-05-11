package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Department;

@Repository
public class DepartmentDao {
	private static ArrayList<Department> DEPARTMENT_LIST;

	public DepartmentDao() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");
		DEPARTMENT_LIST = (ArrayList<Department>) ctx.getBean("departmentList");
	}

	public List<Department> getAllDepartments() {
		return DEPARTMENT_LIST;
	}
}
