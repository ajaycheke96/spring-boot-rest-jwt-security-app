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

import com.ajay.security.api.tenant.entity.EmployeeLeaveAllocation;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeLeaveAllocationService;

@RestController
@RequestMapping("/employeeLeaveAllocation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeLeaveAllocationController {

	@Autowired
	private EmployeeLeaveAllocationService employeeLeaveAllocationService;

	@GetMapping("/listAllEmployeeLeaveAllocation")
	public ApiResponse getAllEmployeeLeaveAllocation() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmployeeLeaveAllocation",
					employeeLeaveAllocationService.getAllEmployeeLeaveAllocations());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveAllocation Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmployeeLeaveAllocation(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeLeaveAllocation",
					employeeLeaveAllocationService.getOneEmployeeLeaveAllocation(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveAllocation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmployeeLeaveAllocation")
	public ApiResponse saveEmployeeLeaveAllocation(@RequestBody EmployeeLeaveAllocation employeeLeaveAllocation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeLeaveAllocation saved!",
					employeeLeaveAllocationService.saveEmployeeLeaveAllocation(employeeLeaveAllocation));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveAllocation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmployeeLeaveAllocation")
	public ApiResponse updateEmployeeLeaveAllocation(@RequestBody EmployeeLeaveAllocation employeeLeaveAllocation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeLeaveAllocation updated!",
					employeeLeaveAllocationService.saveEmployeeLeaveAllocation(employeeLeaveAllocation));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveAllocation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmployeeLeaveAllocation")
	public ApiResponse deleteOneEmployeeLeaveAllocation(@RequestBody EmployeeLeaveAllocation employeeLeaveAllocation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeLeaveAllocationService.deleteOneEmployeeLeaveAllocation(employeeLeaveAllocation), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveAllocation Service exception : " + e.getLocalizedMessage());
		}
	}
}
