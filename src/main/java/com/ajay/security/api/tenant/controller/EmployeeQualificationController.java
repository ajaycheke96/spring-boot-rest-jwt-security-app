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

import com.ajay.security.api.tenant.entity.EmployeeQualification;
import com.ajay.security.api.tenant.service.EmployeeQualificationService;

@RestController
@RequestMapping("/employeeQualification")
public class EmployeeQualificationController {

	@Autowired
	private EmployeeQualificationService employeeQualificationService;

	@GetMapping("/all")
	public List<EmployeeQualification> getAllEmployeeQualification() {
		return employeeQualificationService.getAllEmployeeQualifications();
	}

	@GetMapping("/one/{id}")
	public EmployeeQualification getOneEmployeeQualification(@PathVariable Integer id) {
		return employeeQualificationService.getOneEmployeeQualification(id);
	}

	@PostMapping("/save")
	public String saveEmployeeQualification(@RequestBody EmployeeQualification employeeQualification) {
		return employeeQualificationService.saveEmployeeQualification(employeeQualification);
	}

	@PutMapping("/update")
	public String updateEmployeeQualification(@RequestBody EmployeeQualification employeeQualification) {
		return employeeQualificationService.updateEmployeeQualification(employeeQualification);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeQualification(@PathVariable Integer id) {
		return employeeQualificationService.deleteOneEmployeeQualification(id);
	}
}
