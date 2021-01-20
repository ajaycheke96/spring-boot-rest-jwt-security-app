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

import com.ajay.security.api.tenant.entity.EmployeeAccount;
import com.ajay.security.api.tenant.service.EmployeeAccountService;

@RestController
@RequestMapping("/employeeAccount")
public class EmployeeAccountController {

	@Autowired
	private EmployeeAccountService employeeAccountService;

	@GetMapping("/all")
	public List<EmployeeAccount> getAllEmployeeAccount() {
		return employeeAccountService.getAllEmployeeAccounts();
	}

	@GetMapping("/one/{id}")
	public EmployeeAccount getOneEmployeeAccount(@PathVariable Integer id) {
		return employeeAccountService.getOneEmployeeAccount(id);
	}

	@PostMapping("/save")
	public String saveEmployeeAccount(@RequestBody EmployeeAccount employeeAccount) {
		return employeeAccountService.saveEmployeeAccount(employeeAccount);
	}

	@PutMapping("/update")
	public String updateEmployeeAccount(@RequestBody EmployeeAccount employeeAccount) {
		return employeeAccountService.updateEmployeeAccount(employeeAccount);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeAccount(@PathVariable Integer id) {
		return employeeAccountService.deleteOneEmployeeAccount(id);
	}
}
