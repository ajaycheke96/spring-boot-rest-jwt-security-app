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

import com.ajay.security.api.tenant.entity.EmployeeAttendanceType;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeAttendanceTypeService;

@RestController
@RequestMapping("/employeeAttendanceType")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeAttendanceTypeController {

	@Autowired
	private EmployeeAttendanceTypeService employeeAttendanceTypeService;

	@GetMapping("/listAllEmployeeAttendanceType")
	public ApiResponse getAllEmployeeAttendanceType() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmployeeAttendanceType",
					employeeAttendanceTypeService.getAllEmployeeAttendanceTypes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendanceType Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmployeeAttendanceType(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeAttendanceType",
					employeeAttendanceTypeService.getOneEmployeeAttendanceType(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendanceType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmployeeAttendanceType")
	public ApiResponse saveEmployeeAttendanceType(@RequestBody EmployeeAttendanceType employeeAttendanceType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeAttendanceType saved!",
					employeeAttendanceTypeService.saveEmployeeAttendanceType(employeeAttendanceType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendanceType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmployeeAttendanceType")
	public ApiResponse updateEmployeeAttendanceType(@RequestBody EmployeeAttendanceType employeeAttendanceType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeAttendanceType updated!",
					employeeAttendanceTypeService.saveEmployeeAttendanceType(employeeAttendanceType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendanceType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmployeeAttendanceType")
	public ApiResponse deleteOneEmployeeAttendanceType(@RequestBody EmployeeAttendanceType employeeAttendanceType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeAttendanceTypeService.deleteOneEmployeeAttendanceType(employeeAttendanceType), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendanceType Service exception : " + e.getLocalizedMessage());
		}
	}
}
