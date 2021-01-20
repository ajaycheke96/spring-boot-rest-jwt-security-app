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

import com.ajay.security.api.tenant.entity.EmployeeAttendanceType;
import com.ajay.security.api.tenant.service.EmployeeAttendanceTypeService;

@RestController
@RequestMapping("/employeeAttendanceType")
public class EmployeeAttendanceTypeController {

	@Autowired
	private EmployeeAttendanceTypeService employeeAttendanceTypeService;

	@GetMapping("/all")
	public List<EmployeeAttendanceType> getAllEmployeeAttendanceType() {
		return employeeAttendanceTypeService.getAllEmployeeAttendanceTypes();
	}

	@GetMapping("/one/{id}")
	public EmployeeAttendanceType getOneEmployeeAttendanceType(@PathVariable Integer id) {
		return employeeAttendanceTypeService.getOneEmployeeAttendanceType(id);
	}

	@PostMapping("/save")
	public String saveEmployeeAttendanceType(@RequestBody EmployeeAttendanceType employeeAttendanceType) {
		return employeeAttendanceTypeService.saveEmployeeAttendanceType(employeeAttendanceType);
	}

	@PutMapping("/update")
	public String updateEmployeeAttendanceType(@RequestBody EmployeeAttendanceType employeeAttendanceType) {
		return employeeAttendanceTypeService.updateEmployeeAttendanceType(employeeAttendanceType);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeAttendanceType(@PathVariable Integer id) {
		return employeeAttendanceTypeService.deleteOneEmployeeAttendanceType(id);
	}
}
