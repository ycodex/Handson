package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Department;
import com.cognizant.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@GetMapping(value = "/departments")
	public List<Department> getAllDepartments() {
		return departmentService.getAllDepartments();
	}
}
