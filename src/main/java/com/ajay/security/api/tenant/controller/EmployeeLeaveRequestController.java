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

import com.ajay.security.api.tenant.entity.EmployeeLeaveRequest;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeLeaveRequestService;

@RestController
@RequestMapping("/employeeLeaveRequest")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeLeaveRequestController {

	@Autowired
	private EmployeeLeaveRequestService employeeLeaveRequestService;

	@GetMapping("/listAllEmployeeLeaveRequest")
	public ApiResponse getAllEmployeeLeaveRequest() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmployeeLeaveRequest",
					employeeLeaveRequestService.getAllEmployeeLeaveRequests());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveRequest Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmployeeLeaveRequest(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeLeaveRequest",
					employeeLeaveRequestService.getOneEmployeeLeaveRequest(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveRequest Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmployeeLeaveRequest")
	public ApiResponse saveEmployeeLeaveRequest(@RequestBody EmployeeLeaveRequest employeeLeaveRequest) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeLeaveRequest saved!",
					employeeLeaveRequestService.saveEmployeeLeaveRequest(employeeLeaveRequest));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveRequest Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmployeeLeaveRequest")
	public ApiResponse updateEmployeeLeaveRequest(@RequestBody EmployeeLeaveRequest employeeLeaveRequest) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeLeaveRequest updated!",
					employeeLeaveRequestService.saveEmployeeLeaveRequest(employeeLeaveRequest));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveRequest Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmployeeLeaveRequest")
	public ApiResponse deleteOneEmployeeLeaveRequest(@RequestBody EmployeeLeaveRequest employeeLeaveRequest) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeLeaveRequestService.deleteOneEmployeeLeaveRequest(employeeLeaveRequest), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeLeaveRequest Service exception : " + e.getLocalizedMessage());
		}
	}
}
