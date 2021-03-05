package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.EmployeeLeaveType;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeLeaveTypeService;

@RestController
@RequestMapping("/employeeLeaveType")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeLeaveTypeController {

	@Autowired
	private EmployeeLeaveTypeService employeeLeaveTypeService;

	@GetMapping("/listAllEmployeeLeaveType")
	public ApiResponse getAllEmployeeLeaveType() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmployeeLeaveType",
					employeeLeaveTypeService.getAllEmployeeLeaveTypes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveType Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmployeeLeaveType(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeLeaveType",
					employeeLeaveTypeService.getOneEmployeeLeaveType(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmployeeLeaveType")
	public ApiResponse saveEmployeeLeaveType(@RequestBody EmployeeLeaveType employeeLeaveType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeLeaveType saved!",
					employeeLeaveTypeService.saveEmployeeLeaveType(employeeLeaveType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmployeeLeaveType")
	public ApiResponse updateEmployeeLeaveType(@RequestBody EmployeeLeaveType employeeLeaveType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeLeaveType updated!",
					employeeLeaveTypeService.saveEmployeeLeaveType(employeeLeaveType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmployeeLeaveType")
	public ApiResponse deleteOneEmployeeLeaveType(@RequestBody EmployeeLeaveType employeeLeaveType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeLeaveTypeService.deleteOneEmployeeLeaveType(employeeLeaveType), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveType Service exception : " + e.getLocalizedMessage());
		}
	}
}
