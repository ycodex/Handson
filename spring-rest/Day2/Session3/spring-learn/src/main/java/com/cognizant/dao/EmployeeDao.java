package com.cognizant.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.exception.EmployeeNotFound;
import com.cognizant.model.Employee;

@Repository
public class EmployeeDao {
	private static ArrayList<Employee> EMPLOYEE_LIST;

	public EmployeeDao() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("employee.xml");

		ArrayList<Employee> bean = (ArrayList<Employee>) ctx.getBean("empList");
		EmployeeDao.EMPLOYEE_LIST = bean;
	}

	public List<Employee> getAllEmployees() {
		return EMPLOYEE_LIST;
	}

	public void updateEmployee(Employee employee) throws EmployeeNotFound {
		for (Employee e : EMPLOYEE_LIST) {
			if (e.getId() == employee.getId()) {
				EMPLOYEE_LIST.remove(e);
				EMPLOYEE_LIST.add(employee);
				return;
			}
		}
		throw new EmployeeNotFound();
	}

	public void deleteEmployee(Employee employee) throws EmployeeNotFound {
		for (Employee e : EMPLOYEE_LIST) {
			if (e.getId() == employee.getId()) {
				EMPLOYEE_LIST.remove(e);
				return;
			}
		}
		throw new EmployeeNotFound();
	}

}
