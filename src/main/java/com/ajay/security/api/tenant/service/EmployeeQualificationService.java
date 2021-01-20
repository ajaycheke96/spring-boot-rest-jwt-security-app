package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeQualification;
import com.ajay.security.api.tenant.repository.EmployeeQualificationRepository;

@Service
@Transactional
public class EmployeeQualificationService {

	@Autowired
	private EmployeeQualificationRepository employeeQualificationRepository;

	public List<EmployeeQualification> getAllEmployeeQualifications() {
		return employeeQualificationRepository.findAll();
	}

	public EmployeeQualification getOneEmployeeQualification(Integer id) {
		return employeeQualificationRepository.findById(id).get();
	}

	public String saveEmployeeQualification(EmployeeQualification employeeQualification) {
		return employeeQualificationRepository.save(employeeQualification) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeQualification(EmployeeQualification employeeQualification) {
		return employeeQualificationRepository.save(employeeQualification) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeQualification(Integer id) {
		employeeQualificationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
