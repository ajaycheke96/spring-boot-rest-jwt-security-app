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

import com.ajay.security.api.tenant.entity.Designation;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.DesignationService;

@RestController
@RequestMapping("/designation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class DesignationController {

	@Autowired
	private DesignationService designationService;

	@GetMapping("/listAllDesignation")
	public ApiResponse getAllDesignation() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Designation",
					designationService.getAllDesignations());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Designation Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneDesignation(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Designation",
					designationService.getOneDesignation(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Designation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveDesignation")
	public ApiResponse saveDesignation(@RequestBody Designation designation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Designation saved!",
					designationService.saveDesignation(designation));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Designation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateDesignation")
	public ApiResponse updateDesignation(@RequestBody Designation designation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Designation updated!",
					designationService.saveDesignation(designation));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Designation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteDesignation")
	public ApiResponse deleteOneDesignation(@RequestBody Designation designation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, designationService.deleteOneDesignation(designation),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Designation Service exception : " + e.getLocalizedMessage());
		}
	}
}
