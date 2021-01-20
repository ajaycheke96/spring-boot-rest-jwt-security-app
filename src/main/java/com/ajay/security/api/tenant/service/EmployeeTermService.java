package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeTerm;
import com.ajay.security.api.tenant.repository.EmployeeTermRepository;

@Service
@Transactional
public class EmployeeTermService {

	@Autowired
	private EmployeeTermRepository employeeTermRepository;

	public List<EmployeeTerm> getAllEmployeeTerms() {
		return employeeTermRepository.findAll();
	}

	public EmployeeTerm getOneEmployeeTerm(Integer id) {
		return employeeTermRepository.findById(id).get();
	}

	public String saveEmployeeTerm(EmployeeTerm employeeTerm) {
		return employeeTermRepository.save(employeeTerm) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeTerm(EmployeeTerm employeeTerm) {
		return employeeTermRepository.save(employeeTerm) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeTerm(Integer id) {
		employeeTermRepository.deleteById(id);
		return " successfully deleted!";
	}
}
