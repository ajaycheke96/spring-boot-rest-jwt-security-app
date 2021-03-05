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

import com.ajay.security.api.tenant.entity.EmployeeCategory;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeCategoryService;

@RestController
@RequestMapping("/employeeCategory")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeCategoryController {

	@Autowired
	private EmployeeCategoryService employeeCategoryService;

	@GetMapping("/listAllEmployeeCategory")
	public ApiResponse getAllEmployeeCategory() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmployeeCategory",
					employeeCategoryService.getAllEmployeeCategorys());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmployeeCategory(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeCategory",
					employeeCategoryService.getOneEmployeeCategory(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmployeeCategory")
	public ApiResponse saveEmployeeCategory(@RequestBody EmployeeCategory employeeCategory) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeCategory saved!",
					employeeCategoryService.saveEmployeeCategory(employeeCategory));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmployeeCategory")
	public ApiResponse updateEmployeeCategory(@RequestBody EmployeeCategory employeeCategory) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeCategory updated!",
					employeeCategoryService.saveEmployeeCategory(employeeCategory));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmployeeCategory")
	public ApiResponse deleteOneEmployeeCategory(@RequestBody EmployeeCategory employeeCategory) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeCategoryService.deleteOneEmployeeCategory(employeeCategory), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeCategory Service exception : " + e.getLocalizedMessage());
		}
	}
}
