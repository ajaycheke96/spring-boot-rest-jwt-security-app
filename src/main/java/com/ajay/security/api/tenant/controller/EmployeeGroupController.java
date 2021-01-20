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

import com.ajay.security.api.tenant.entity.EmployeeGroup;
import com.ajay.security.api.tenant.service.EmployeeGroupService;

@RestController
@RequestMapping("/employeeGroup")
public class EmployeeGroupController {

	@Autowired
	private EmployeeGroupService employeeGroupService;

	@GetMapping("/all")
	public List<EmployeeGroup> getAllEmployeeGroup() {
		return employeeGroupService.getAllEmployeeGroups();
	}

	@GetMapping("/one/{id}")
	public EmployeeGroup getOneEmployeeGroup(@PathVariable Integer id) {
		return employeeGroupService.getOneEmployeeGroup(id);
	}

	@PostMapping("/save")
	public String saveEmployeeGroup(@RequestBody EmployeeGroup employeeGroup) {
		return employeeGroupService.saveEmployeeGroup(employeeGroup);
	}

	@PutMapping("/update")
	public String updateEmployeeGroup(@RequestBody EmployeeGroup employeeGroup) {
		return employeeGroupService.updateEmployeeGroup(employeeGroup);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeGroup(@PathVariable Integer id) {
		return employeeGroupService.deleteOneEmployeeGroup(id);
	}
}
