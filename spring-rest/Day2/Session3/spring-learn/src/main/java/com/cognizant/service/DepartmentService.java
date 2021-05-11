package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.dao.DepartmentDao;
import com.cognizant.model.Department;

@Service
public class DepartmentService {
	@Autowired
	DepartmentDao dao;

	@Transactional
	public List<Department> getAllDepartments() {
		return dao.getAllDepartments();
	}
}
