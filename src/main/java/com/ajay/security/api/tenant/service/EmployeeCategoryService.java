package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.EmployeeCategory;
import com.ajay.security.api.tenant.repository.EmployeeCategoryRepository;

@Service
public class EmployeeCategoryService {

	@Autowired
	private EmployeeCategoryRepository employeeCategoryRepository;

	public List<EmployeeCategory> getAllEmployeeCategorys() {
		return employeeCategoryRepository.findAll();
	}

	public EmployeeCategory getOneEmployeeCategory(Integer id) {
		return employeeCategoryRepository.findById(id).get();
	}

	public String saveEmployeeCategory(EmployeeCategory employeeCategory) {
		return employeeCategoryRepository.save(employeeCategory) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeCategory(EmployeeCategory employeeCategory) {
		return employeeCategoryRepository.save(employeeCategory) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeCategory(Integer id) {
		employeeCategoryRepository.deleteById(id);
		return " successfully deleted!";
	}
}
