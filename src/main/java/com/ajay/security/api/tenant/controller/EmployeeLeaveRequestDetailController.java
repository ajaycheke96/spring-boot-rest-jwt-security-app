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

import com.ajay.security.api.tenant.entity.EmployeeLeaveRequestDetail;
import com.ajay.security.api.tenant.service.EmployeeLeaveRequestDetailService;

@RestController
@RequestMapping("/employeeLeaveRequestDetail")
public class EmployeeLeaveRequestDetailController {

	@Autowired
	private EmployeeLeaveRequestDetailService employeeLeaveRequestDetailService;

	@GetMapping("/all")
	public List<EmployeeLeaveRequestDetail> getAllEmployeeLeaveRequestDetail() {
		return employeeLeaveRequestDetailService.getAllEmployeeLeaveRequestDetails();
	}

	@GetMapping("/one/{id}")
	public EmployeeLeaveRequestDetail getOneEmployeeLeaveRequestDetail(@PathVariable Integer id) {
		return employeeLeaveRequestDetailService.getOneEmployeeLeaveRequestDetail(id);
	}

	@PostMapping("/save")
	public String saveEmployeeLeaveRequestDetail(@RequestBody EmployeeLeaveRequestDetail employeeLeaveRequestDetail) {
		return employeeLeaveRequestDetailService.saveEmployeeLeaveRequestDetail(employeeLeaveRequestDetail);
	}

	@PutMapping("/update")
	public String updateEmployeeLeaveRequestDetail(@RequestBody EmployeeLeaveRequestDetail employeeLeaveRequestDetail) {
		return employeeLeaveRequestDetailService.updateEmployeeLeaveRequestDetail(employeeLeaveRequestDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeLeaveRequestDetail(@PathVariable Integer id) {
		return employeeLeaveRequestDetailService.deleteOneEmployeeLeaveRequestDetail(id);
	}
}
