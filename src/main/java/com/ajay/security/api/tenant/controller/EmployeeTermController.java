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

import com.ajay.security.api.tenant.entity.EmployeeTerm;
import com.ajay.security.api.tenant.service.EmployeeTermService;

@RestController
@RequestMapping("/employeeTerm")
public class EmployeeTermController {

	@Autowired
	private EmployeeTermService employeeTermService;

	@GetMapping("/all")
	public List<EmployeeTerm> getAllEmployeeTerm() {
		return employeeTermService.getAllEmployeeTerms();
	}

	@GetMapping("/one/{id}")
	public EmployeeTerm getOneEmployeeTerm(@PathVariable Integer id) {
		return employeeTermService.getOneEmployeeTerm(id);
	}

	@PostMapping("/save")
	public String saveEmployeeTerm(@RequestBody EmployeeTerm employeeTerm) {
		return employeeTermService.saveEmployeeTerm(employeeTerm);
	}

	@PutMapping("/update")
	public String updateEmployeeTerm(@RequestBody EmployeeTerm employeeTerm) {
		return employeeTermService.updateEmployeeTerm(employeeTerm);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeTerm(@PathVariable Integer id) {
		return employeeTermService.deleteOneEmployeeTerm(id);
	}
}
