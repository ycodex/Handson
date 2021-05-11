package com.cognizant.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.EmployeeNotFound;
import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@PutMapping(value = "/employee")
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFound {
		employeeService.updateEmployee(employee);
	}

	@DeleteMapping(value = "/employee")
	public void deleteEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFound {
		employeeService.deleteEmployee(employee);
	}
}
