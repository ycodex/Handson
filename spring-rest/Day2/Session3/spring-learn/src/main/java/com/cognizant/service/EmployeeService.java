package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.EmployeeDao;
import com.cognizant.exception.EmployeeNotFound;
import com.cognizant.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	@Transactional
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Transactional
	public void updateEmployee(Employee employee) throws EmployeeNotFound {
		employeeDao.updateEmployee(employee);
	}

	@Transactional
	public void deleteEmployee(Employee employee) throws EmployeeNotFound {
		employeeDao.deleteEmployee(employee);
	}
}
