package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.EmployeeCategory;
import com.ajay.security.api.tenant.service.EmployeeCategoryService;

@RestController
@RequestMapping("/employeeCategory")
public class EmployeeCategoryController {

	@Autowired
	private EmployeeCategoryService employeeCategoryService;

	@GetMapping("/all")
	public List<EmployeeCategory> getAllEmployeeCategory() {
		return employeeCategoryService.getAllEmployeeCategorys();
	}

	@GetMapping("/one/{id}")
	public EmployeeCategory getOneEmployeeCategory(@PathVariable Integer id) {
		return employeeCategoryService.getOneEmployeeCategory(id);
	}

	@PostMapping("/save")
	public String saveEmployeeCategory(@RequestBody EmployeeCategory employeeCategory) {
		return employeeCategoryService.saveEmployeeCategory(employeeCategory);
	}

	@PutMapping("/update")
	public String updateEmployeeCategory(@RequestBody EmployeeCategory employeeCategory) {
		return employeeCategoryService.updateEmployeeCategory(employeeCategory);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeCategory(@PathVariable Integer id) {
		return employeeCategoryService.deleteOneEmployeeCategory(id);
	}
}
