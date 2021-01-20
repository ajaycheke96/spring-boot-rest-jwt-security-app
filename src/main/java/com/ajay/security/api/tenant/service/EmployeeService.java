package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Employee;
import com.ajay.security.api.tenant.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Employee getOneEmployee(Integer id) {
		return employeeRepository.findById(id).get();
	}

	public String saveEmployee(Employee employee) {
		return employeeRepository.save(employee) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEmployee(Employee employee) {
		return employeeRepository.save(employee) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneEmployee(Integer id) {
		employeeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
