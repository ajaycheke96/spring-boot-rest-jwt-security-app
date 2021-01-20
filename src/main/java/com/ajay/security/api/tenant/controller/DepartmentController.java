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

import com.ajay.security.api.tenant.entity.Department;
import com.ajay.security.api.tenant.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/all")
	public List<Department> getAllDepartment() {
		return departmentService.getAllDepartments();
	}

	@GetMapping("/one/{id}")
	public Department getOneDepartment(@PathVariable Integer id) {
		return departmentService.getOneDepartment(id);
	}

	@PostMapping("/save")
	public String saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@PutMapping("/update")
	public String updateDepartment(@RequestBody Department department) {
		return departmentService.updateDepartment(department);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneDepartment(@PathVariable Integer id) {
		return departmentService.deleteOneDepartment(id);
	}
}
