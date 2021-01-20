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

import com.ajay.security.api.tenant.entity.EmployeeLeaveRequest;
import com.ajay.security.api.tenant.service.EmployeeLeaveRequestService;

@RestController
@RequestMapping("/employeeLeaveRequest")
public class EmployeeLeaveRequestController {

	@Autowired
	private EmployeeLeaveRequestService employeeLeaveRequestService;

	@GetMapping("/all")
	public List<EmployeeLeaveRequest> getAllEmployeeLeaveRequest() {
		return employeeLeaveRequestService.getAllEmployeeLeaveRequests();
	}

	@GetMapping("/one/{id}")
	public EmployeeLeaveRequest getOneEmployeeLeaveRequest(@PathVariable Integer id) {
		return employeeLeaveRequestService.getOneEmployeeLeaveRequest(id);
	}

	@PostMapping("/save")
	public String saveEmployeeLeaveRequest(@RequestBody EmployeeLeaveRequest employeeLeaveRequest) {
		return employeeLeaveRequestService.saveEmployeeLeaveRequest(employeeLeaveRequest);
	}

	@PutMapping("/update")
	public String updateEmployeeLeaveRequest(@RequestBody EmployeeLeaveRequest employeeLeaveRequest) {
		return employeeLeaveRequestService.updateEmployeeLeaveRequest(employeeLeaveRequest);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeLeaveRequest(@PathVariable Integer id) {
		return employeeLeaveRequestService.deleteOneEmployeeLeaveRequest(id);
	}
}
