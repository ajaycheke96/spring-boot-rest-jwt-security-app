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

import com.ajay.security.api.tenant.entity.EmployeeLeaveAllocation;
import com.ajay.security.api.tenant.service.EmployeeLeaveAllocationService;

@RestController
@RequestMapping("/employeeLeaveAllocation")
public class EmployeeLeaveAllocationController {

	@Autowired
	private EmployeeLeaveAllocationService employeeLeaveAllocationService;

	@GetMapping("/all")
	public List<EmployeeLeaveAllocation> getAllEmployeeLeaveAllocation() {
		return employeeLeaveAllocationService.getAllEmployeeLeaveAllocations();
	}

	@GetMapping("/one/{id}")
	public EmployeeLeaveAllocation getOneEmployeeLeaveAllocation(@PathVariable Integer id) {
		return employeeLeaveAllocationService.getOneEmployeeLeaveAllocation(id);
	}

	@PostMapping("/save")
	public String saveEmployeeLeaveAllocation(@RequestBody EmployeeLeaveAllocation employeeLeaveAllocation) {
		return employeeLeaveAllocationService.saveEmployeeLeaveAllocation(employeeLeaveAllocation);
	}

	@PutMapping("/update")
	public String updateEmployeeLeaveAllocation(@RequestBody EmployeeLeaveAllocation employeeLeaveAllocation) {
		return employeeLeaveAllocationService.updateEmployeeLeaveAllocation(employeeLeaveAllocation);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeLeaveAllocation(@PathVariable Integer id) {
		return employeeLeaveAllocationService.deleteOneEmployeeLeaveAllocation(id);
	}
}
