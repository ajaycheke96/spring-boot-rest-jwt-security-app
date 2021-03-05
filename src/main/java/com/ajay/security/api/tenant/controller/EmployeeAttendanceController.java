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

import com.ajay.security.api.tenant.entity.EmployeeAttendance;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeAttendanceService;

@RestController
@RequestMapping("/employeeAttendance")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeAttendanceController {

	@Autowired
	private EmployeeAttendanceService employeeAttendanceService;

	@GetMapping("/listAllEmployeeAttendance")
	public ApiResponse getAllEmployeeAttendance() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmployeeAttendance",
					employeeAttendanceService.getAllEmployeeAttendances());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendance Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmployeeAttendance(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeAttendance",
					employeeAttendanceService.getOneEmployeeAttendance(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendance Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmployeeAttendance")
	public ApiResponse saveEmployeeAttendance(@RequestBody EmployeeAttendance employeeAttendance) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeAttendance saved!",
					employeeAttendanceService.saveEmployeeAttendance(employeeAttendance));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendance Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmployeeAttendance")
	public ApiResponse updateEmployeeAttendance(@RequestBody EmployeeAttendance employeeAttendance) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeAttendance updated!",
					employeeAttendanceService.saveEmployeeAttendance(employeeAttendance));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendance Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmployeeAttendance")
	public ApiResponse deleteOneEmployeeAttendance(@RequestBody EmployeeAttendance employeeAttendance) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeAttendanceService.deleteOneEmployeeAttendance(employeeAttendance), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeAttendance Service exception : " + e.getLocalizedMessage());
		}
	}
}
