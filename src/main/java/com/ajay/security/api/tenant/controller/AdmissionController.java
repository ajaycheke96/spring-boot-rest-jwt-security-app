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

import com.ajay.security.api.tenant.entity.Admission;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.AdmissionService;

@RestController
@RequestMapping("/admission")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AdmissionController {

	@Autowired
	private AdmissionService admissionService;

	@GetMapping("/listAllAdmission")
	public ApiResponse getAllAdmission() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Admission",
					admissionService.getAllAdmissions());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Admission Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneAdmission(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Admission", admissionService.getOneAdmission(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Admission Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveAdmission")
	public ApiResponse saveAdmission(@RequestBody Admission admission) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Admission saved!",
					admissionService.saveAdmission(admission));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Admission Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateAdmission")
	public ApiResponse updateAdmission(@RequestBody Admission admission) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Admission updated!",
					admissionService.saveAdmission(admission));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Admission Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteAdmission")
	public ApiResponse deleteOneAdmission(@RequestBody Admission admission) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, admissionService.deleteOneAdmission(admission),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Admission Service exception : " + e.getLocalizedMessage());
		}
	}
}
