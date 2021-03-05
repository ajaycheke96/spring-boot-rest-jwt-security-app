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

import com.ajay.security.api.tenant.entity.EmployeeGroup;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeGroupService;

@RestController
@RequestMapping("/employeeGroup")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeGroupController {

	@Autowired
	private EmployeeGroupService employeeGroupService;

	@GetMapping("/listAllEmployeeGroup")
	public ApiResponse getAllEmployeeGroup() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmployeeGroup",
					employeeGroupService.getAllEmployeeGroups());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmployeeGroup(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeGroup",
					employeeGroupService.getOneEmployeeGroup(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmployeeGroup")
	public ApiResponse saveEmployeeGroup(@RequestBody EmployeeGroup employeeGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeGroup saved!",
					employeeGroupService.saveEmployeeGroup(employeeGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmployeeGroup")
	public ApiResponse updateEmployeeGroup(@RequestBody EmployeeGroup employeeGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeGroup updated!",
					employeeGroupService.saveEmployeeGroup(employeeGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmployeeGroup")
	public ApiResponse deleteOneEmployeeGroup(@RequestBody EmployeeGroup employeeGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeGroupService.deleteOneEmployeeGroup(employeeGroup), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}
}
