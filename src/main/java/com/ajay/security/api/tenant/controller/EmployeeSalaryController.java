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

import com.ajay.security.api.tenant.entity.EmployeeSalary;
import com.ajay.security.api.tenant.service.EmployeeSalaryService;

@RestController
@RequestMapping("/employeeSalary")
public class EmployeeSalaryController {

	@Autowired
	private EmployeeSalaryService employeeSalaryService;

	@GetMapping("/all")
	public List<EmployeeSalary> getAllEmployeeSalary() {
		return employeeSalaryService.getAllEmployeeSalarys();
	}

	@GetMapping("/one/{id}")
	public EmployeeSalary getOneEmployeeSalary(@PathVariable Integer id) {
		return employeeSalaryService.getOneEmployeeSalary(id);
	}

	@PostMapping("/save")
	public String saveEmployeeSalary(@RequestBody EmployeeSalary employeeSalary) {
		return employeeSalaryService.saveEmployeeSalary(employeeSalary);
	}

	@PutMapping("/update")
	public String updateEmployeeSalary(@RequestBody EmployeeSalary employeeSalary) {
		return employeeSalaryService.updateEmployeeSalary(employeeSalary);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeSalary(@PathVariable Integer id) {
		return employeeSalaryService.deleteOneEmployeeSalary(id);
	}
}
