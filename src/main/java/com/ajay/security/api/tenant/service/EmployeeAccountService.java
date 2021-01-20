package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.EmployeeAccount;
import com.ajay.security.api.tenant.repository.EmployeeAccountRepository;

@Service
public class EmployeeAccountService {

	@Autowired
	private EmployeeAccountRepository employeeAccountRepository;

	public List<EmployeeAccount> getAllEmployeeAccounts() {
		return employeeAccountRepository.findAll();
	}

	public EmployeeAccount getOneEmployeeAccount(Integer id) {
		return employeeAccountRepository.findById(id).get();
	}

	public String saveEmployeeAccount(EmployeeAccount employeeAccount) {
		return employeeAccountRepository.save(employeeAccount) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeAccount(EmployeeAccount employeeAccount) {
		return employeeAccountRepository.save(employeeAccount) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeAccount(Integer id) {
		employeeAccountRepository.deleteById(id);
		return " successfully deleted!";
	}
}
