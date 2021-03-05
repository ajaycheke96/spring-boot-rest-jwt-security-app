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

import com.ajay.security.api.tenant.entity.EmployeeDocumentType;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.EmployeeDocumentTypeService;

@RestController
@RequestMapping("/employeeDocumentType")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EmployeeDocumentTypeController {

	@Autowired
	private EmployeeDocumentTypeService employeeDocumentTypeService;

	@GetMapping("/listAllEmployeeDocumentType")
	public ApiResponse getAllEmployeeDocumentType() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of EmployeeDocumentType",
					employeeDocumentTypeService.getAllEmployeeDocumentTypes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneEmployeeDocumentType(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeDocumentType",
					employeeDocumentTypeService.getOneEmployeeDocumentType(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveEmployeeDocumentType")
	public ApiResponse saveEmployeeDocumentType(@RequestBody EmployeeDocumentType employeeDocumentType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeDocumentType saved!",
					employeeDocumentTypeService.saveEmployeeDocumentType(employeeDocumentType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateEmployeeDocumentType")
	public ApiResponse updateEmployeeDocumentType(@RequestBody EmployeeDocumentType employeeDocumentType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "EmployeeDocumentType updated!",
					employeeDocumentTypeService.saveEmployeeDocumentType(employeeDocumentType));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteEmployeeDocumentType")
	public ApiResponse deleteOneEmployeeDocumentType(@RequestBody EmployeeDocumentType employeeDocumentType) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					employeeDocumentTypeService.deleteOneEmployeeDocumentType(employeeDocumentType), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"EmployeeDocumentType Service exception : " + e.getLocalizedMessage());
		}
	}
}
