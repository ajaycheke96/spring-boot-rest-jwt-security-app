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

import com.ajay.security.api.tenant.entity.EmployeeDesignation;
import com.ajay.security.api.tenant.service.EmployeeDesignationService;

@RestController
@RequestMapping("/employeeDesignation")
public class EmployeeDesignationController {

	@Autowired
	private EmployeeDesignationService employeeDesignationService;

	@GetMapping("/all")
	public List<EmployeeDesignation> getAllEmployeeDesignation() {
		return employeeDesignationService.getAllEmployeeDesignations();
	}

	@GetMapping("/one/{id}")
	public EmployeeDesignation getOneEmployeeDesignation(@PathVariable Integer id) {
		return employeeDesignationService.getOneEmployeeDesignation(id);
	}

	@PostMapping("/save")
	public String saveEmployeeDesignation(@RequestBody EmployeeDesignation employeeDesignation) {
		return employeeDesignationService.saveEmployeeDesignation(employeeDesignation);
	}

	@PutMapping("/update")
	public String updateEmployeeDesignation(@RequestBody EmployeeDesignation employeeDesignation) {
		return employeeDesignationService.updateEmployeeDesignation(employeeDesignation);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeDesignation(@PathVariable Integer id) {
		return employeeDesignationService.deleteOneEmployeeDesignation(id);
	}
}
