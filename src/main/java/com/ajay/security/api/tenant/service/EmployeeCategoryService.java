package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeCategory;
import com.ajay.security.api.tenant.repository.EmployeeCategoryRepository;

@Service
@Transactional
public class EmployeeCategoryService {

	@Autowired
	private EmployeeCategoryRepository employeeCategoryRepository;

	public List<EmployeeCategory> getAllEmployeeCategorys() {
		return employeeCategoryRepository.findAll();
	}

	public EmployeeCategory getOneEmployeeCategory(Integer id) {
		return employeeCategoryRepository.findById(id).get();
	}

	public EmployeeCategory saveEmployeeCategory(EmployeeCategory employeeCategory) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employeeCategory.getCreatedAt() == null)
			employeeCategory.setCreatedAt(currentTimestamp);
		employeeCategory.setUpdatedAt(currentTimestamp);
		return employeeCategoryRepository.save(employeeCategory);
	}

	public String deleteOneEmployeeCategory(EmployeeCategory employeeCategory) {
		String result = null;
		if (employeeCategoryRepository.existsById(employeeCategory.getId())) {
			employeeCategoryRepository.delete(employeeCategory);
			result = " EmployeeCategory deleted!";
		} else {
			result = "EmployeeCategory Not Found! or Already deleted!";
		}
		return result;
	}
}
