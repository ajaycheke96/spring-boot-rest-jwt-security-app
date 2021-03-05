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

import com.ajay.security.api.tenant.entity.EmployeeTerm;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeTermService;

@RestController
@RequestMapping("/employeeTerm")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeTermController {

	@Autowired
	private EmployeeTermService employeeTermService;

	@GetMapping("/listAllEmployeeTerm")
	public ApiResponse getAllEmployeeTerm() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmployeeTerm",
					employeeTermService.getAllEmployeeTerms());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeTerm Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmployeeTerm(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeTerm",
					employeeTermService.getOneEmployeeTerm(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeTerm Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmployeeTerm")
	public ApiResponse saveEmployeeTerm(@RequestBody EmployeeTerm employeeTerm) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeTerm saved!",
					employeeTermService.saveEmployeeTerm(employeeTerm));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeTerm Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmployeeTerm")
	public ApiResponse updateEmployeeTerm(@RequestBody EmployeeTerm employeeTerm) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeTerm updated!",
					employeeTermService.saveEmployeeTerm(employeeTerm));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeTerm Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmployeeTerm")
	public ApiResponse deleteOneEmployeeTerm(@RequestBody EmployeeTerm employeeTerm) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeTermService.deleteOneEmployeeTerm(employeeTerm), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeTerm Service exception : " + e.getLocalizedMessage());
		}
	}
}
