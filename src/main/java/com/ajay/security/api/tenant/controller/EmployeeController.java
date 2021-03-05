package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Employee;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/listAllEmployee")
	public ApiResponse getAllEmployee() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Employee",
					employeeService.getAllEmployees());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Employee Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/{id}")
	public ApiResponse getOneEmployee(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Employee", employeeService.getOneEmployee(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Employee Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ApiResponse saveEmployee(@RequestBody Employee employee) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Employee saved!",
					employeeService.saveEmployee(employee));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Employee Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public ApiResponse updateEmployee(@RequestBody Employee employee) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Employee updated!",
					employeeService.saveEmployee(employee));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Employee Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
	public ApiResponse deleteOneEmployee(@RequestBody Employee employee) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeService.deleteOneEmployee(employee), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Employee Service exception : " + e.getLocalizedMessage());
		}

	}
}
