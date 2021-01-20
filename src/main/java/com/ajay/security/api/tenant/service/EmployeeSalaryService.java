package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeSalary;
import com.ajay.security.api.tenant.repository.EmployeeSalaryRepository;

@Service
@Transactional
public class EmployeeSalaryService {

	@Autowired
	private EmployeeSalaryRepository employeeSalaryRepository;

	public List<EmployeeSalary> getAllEmployeeSalarys() {
		return employeeSalaryRepository.findAll();
	}

	public EmployeeSalary getOneEmployeeSalary(Integer id) {
		return employeeSalaryRepository.findById(id).get();
	}

	public String saveEmployeeSalary(EmployeeSalary employeeSalary) {
		return employeeSalaryRepository.save(employeeSalary) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeSalary(EmployeeSalary employeeSalary) {
		return employeeSalaryRepository.save(employeeSalary) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeSalary(Integer id) {
		employeeSalaryRepository.deleteById(id);
		return " successfully deleted!";
	}
}
