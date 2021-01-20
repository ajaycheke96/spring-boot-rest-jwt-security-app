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

import com.ajay.security.api.tenant.entity.EmployeeLeaveAllocationDetail;
import com.ajay.security.api.tenant.service.EmployeeLeaveAllocationDetailService;

@RestController
@RequestMapping("/employeeLeaveAllocationDetail")
public class EmployeeLeaveAllocationDetailController {

	@Autowired
	private EmployeeLeaveAllocationDetailService employeeLeaveAllocationDetailService;

	@GetMapping("/all")
	public List<EmployeeLeaveAllocationDetail> getAllEmployeeLeaveAllocationDetail() {
		return employeeLeaveAllocationDetailService.getAllEmployeeLeaveAllocationDetails();
	}

	@GetMapping("/one/{id}")
	public EmployeeLeaveAllocationDetail getOneEmployeeLeaveAllocationDetail(@PathVariable Integer id) {
		return employeeLeaveAllocationDetailService.getOneEmployeeLeaveAllocationDetail(id);
	}

	@PostMapping("/save")
	public String saveEmployeeLeaveAllocationDetail(
			@RequestBody EmployeeLeaveAllocationDetail employeeLeaveAllocationDetail) {
		return employeeLeaveAllocationDetailService.saveEmployeeLeaveAllocationDetail(employeeLeaveAllocationDetail);
	}

	@PutMapping("/update")
	public String updateEmployeeLeaveAllocationDetail(
			@RequestBody EmployeeLeaveAllocationDetail employeeLeaveAllocationDetail) {
		return employeeLeaveAllocationDetailService.updateEmployeeLeaveAllocationDetail(employeeLeaveAllocationDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeLeaveAllocationDetail(@PathVariable Integer id) {
		return employeeLeaveAllocationDetailService.deleteOneEmployeeLeaveAllocationDetail(id);
	}
}
