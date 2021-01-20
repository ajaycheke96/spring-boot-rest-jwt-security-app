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

import com.ajay.security.api.tenant.entity.EmployeeAttendance;
import com.ajay.security.api.tenant.service.EmployeeAttendanceService;

@RestController
@RequestMapping("/employeeAttendance")
public class EmployeeAttendanceController {

	@Autowired
	private EmployeeAttendanceService employeeAttendanceService;

	@GetMapping("/all")
	public List<EmployeeAttendance> getAllEmployeeAttendance() {
		return employeeAttendanceService.getAllEmployeeAttendances();
	}

	@GetMapping("/one/{id}")
	public EmployeeAttendance getOneEmployeeAttendance(@PathVariable Integer id) {
		return employeeAttendanceService.getOneEmployeeAttendance(id);
	}

	@PostMapping("/save")
	public String saveEmployeeAttendance(@RequestBody EmployeeAttendance employeeAttendance) {
		return employeeAttendanceService.saveEmployeeAttendance(employeeAttendance);
	}

	@PutMapping("/update")
	public String updateEmployeeAttendance(@RequestBody EmployeeAttendance employeeAttendance) {
		return employeeAttendanceService.updateEmployeeAttendance(employeeAttendance);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeAttendance(@PathVariable Integer id) {
		return employeeAttendanceService.deleteOneEmployeeAttendance(id);
	}
}
