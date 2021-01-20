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

import com.ajay.security.api.tenant.entity.EmployeeAttendanceDetail;
import com.ajay.security.api.tenant.service.EmployeeAttendanceDetailService;

@RestController
@RequestMapping("/employeeAttendanceDetail")
public class EmployeeAttendanceDetailController {

	@Autowired
	private EmployeeAttendanceDetailService employeeAttendanceDetailService;

	@GetMapping("/all")
	public List<EmployeeAttendanceDetail> getAllEmployeeAttendanceDetail() {
		return employeeAttendanceDetailService.getAllEmployeeAttendanceDetails();
	}

	@GetMapping("/one/{id}")
	public EmployeeAttendanceDetail getOneEmployeeAttendanceDetail(@PathVariable Integer id) {
		return employeeAttendanceDetailService.getOneEmployeeAttendanceDetail(id);
	}

	@PostMapping("/save")
	public String saveEmployeeAttendanceDetail(@RequestBody EmployeeAttendanceDetail employeeAttendanceDetail) {
		return employeeAttendanceDetailService.saveEmployeeAttendanceDetail(employeeAttendanceDetail);
	}

	@PutMapping("/update")
	public String updateEmployeeAttendanceDetail(@RequestBody EmployeeAttendanceDetail employeeAttendanceDetail) {
		return employeeAttendanceDetailService.updateEmployeeAttendanceDetail(employeeAttendanceDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeAttendanceDetail(@PathVariable Integer id) {
		return employeeAttendanceDetailService.deleteOneEmployeeAttendanceDetail(id);
	}
}
