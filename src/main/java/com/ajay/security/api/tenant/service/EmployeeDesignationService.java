package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.EmployeeDesignation;
import com.ajay.security.api.tenant.repository.EmployeeDesignationRepository;

@Service
public class EmployeeDesignationService {

	@Autowired
	private EmployeeDesignationRepository employeeDesignationRepository;

	public List<EmployeeDesignation> getAllEmployeeDesignations() {
		return employeeDesignationRepository.findAll();
	}

	public EmployeeDesignation getOneEmployeeDesignation(Integer id) {
		return employeeDesignationRepository.findById(id).get();
	}

	public String saveEmployeeDesignation(EmployeeDesignation employeeDesignation) {
		return employeeDesignationRepository.save(employeeDesignation) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeDesignation(EmployeeDesignation employeeDesignation) {
		return employeeDesignationRepository.save(employeeDesignation) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeDesignation(Integer id) {
		employeeDesignationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
