package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Department saveDepartment(Department department) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (department.getCreatedAt() == null)
			department.setCreatedAt(currentTimestamp);
		department.setUpdatedAt(currentTimestamp);
		return departmentRepository.save(department);
	}

	public String deleteOneDepartment(Department department) {
		String result = null;
		if (departmentRepository.existsById(department.getId())) {
			departmentRepository.delete(department);
			result = " Department deleted!";
		} else {
			result = "Department Not Found! or Already deleted!";
		}
		return result;
	}
}
