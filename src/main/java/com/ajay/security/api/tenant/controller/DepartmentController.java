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

import com.ajay.security.api.tenant.entity.Department;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.DepartmentService;

@RestController
@RequestMapping("/department")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/listAllDepartment")
	public ApiResponse getAllDepartment() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Department",
					departmentService.getAllDepartments());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Department Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneDepartment(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Department",
					departmentService.getOneDepartment(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Department Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveDepartment")
	public ApiResponse saveDepartment(@RequestBody Department department) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Department saved!",
					departmentService.saveDepartment(department));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Department Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateDepartment")
	public ApiResponse updateDepartment(@RequestBody Department department) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Department updated!",
					departmentService.saveDepartment(department));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Department Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteDepartment")
	public ApiResponse deleteOneDepartment(@RequestBody Department department) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, departmentService.deleteOneDepartment(department), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Department Service exception : " + e.getLocalizedMessage());
		}

	}
}
