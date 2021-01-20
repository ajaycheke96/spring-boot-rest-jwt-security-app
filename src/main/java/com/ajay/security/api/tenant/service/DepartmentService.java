package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Department;
import com.ajay.security.api.tenant.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAllDepartments() {
		return departmentRepository.findAll();
	}

	public Department getOneDepartment(Integer id) {
		return departmentRepository.findById(id).get();
	}

	public String saveDepartment(Department department) {
		return departmentRepository.save(department) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateDepartment(Department department) {
		return departmentRepository.save(department) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneDepartment(Integer id) {
		departmentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
