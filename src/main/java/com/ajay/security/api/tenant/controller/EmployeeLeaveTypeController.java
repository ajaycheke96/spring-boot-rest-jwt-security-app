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

import com.ajay.security.api.tenant.entity.EmployeeLeaveType;
import com.ajay.security.api.tenant.service.EmployeeLeaveTypeService;

@RestController
@RequestMapping("/employeeLeaveType")
public class EmployeeLeaveTypeController {

	@Autowired
	private EmployeeLeaveTypeService employeeLeaveTypeService;

	@GetMapping("/all")
	public List<EmployeeLeaveType> getAllEmployeeLeaveType() {
		return employeeLeaveTypeService.getAllEmployeeLeaveTypes();
	}

	@GetMapping("/one/{id}")
	public EmployeeLeaveType getOneEmployeeLeaveType(@PathVariable Integer id) {
		return employeeLeaveTypeService.getOneEmployeeLeaveType(id);
	}

	@PostMapping("/save")
	public String saveEmployeeLeaveType(@RequestBody EmployeeLeaveType employeeLeaveType) {
		return employeeLeaveTypeService.saveEmployeeLeaveType(employeeLeaveType);
	}

	@PutMapping("/update")
	public String updateEmployeeLeaveType(@RequestBody EmployeeLeaveType employeeLeaveType) {
		return employeeLeaveTypeService.updateEmployeeLeaveType(employeeLeaveType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeLeaveType(@PathVariable Integer id) {
		return employeeLeaveTypeService.deleteOneEmployeeLeaveType(id);
	}
}
