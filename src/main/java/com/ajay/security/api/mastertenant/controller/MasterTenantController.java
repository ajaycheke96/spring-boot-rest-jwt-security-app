package com.ajay.security.api.mastertenant.controller;

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

import com.ajay.security.api.mastertenant.entity.MasterTenantEntity;
import com.ajay.security.api.mastertenant.service.MasterTenantService;
import com.ajay.security.api.tenant.model.ApiResponse;

import javassist.NotFoundException;

@RestController
@RequestMapping("/tenant/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MasterTenantController {

	@Autowired
	private MasterTenantService masterTenantService;

	@GetMapping("/listAllMasterTenantEntity")
	public ApiResponse getAllTenants() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of MasterTenantEntity",
					masterTenantService.findAllTenants());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"MasterTenantEntity Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTenant(@PathVariable Integer id) throws NotFoundException {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "MasterTenantEntity",
					masterTenantService.findById(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"MasterTenantEntity Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveMasterTenantEntity")
	public ApiResponse saveTenant(@RequestBody MasterTenantEntity masterTenantEntity) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "MasterTenantEntity saved!",
					masterTenantService.saveOrUpdateTenant(masterTenantEntity));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"MasterTenantEntity Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateMasterTenantEntity")
	public ApiResponse updateTenant(@RequestBody MasterTenantEntity masterTenantEntity) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "MasterTenantEntity updated!",
					masterTenantService.saveOrUpdateTenant(masterTenantEntity));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"MasterTenantEntity Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteMasterTenantEntity")
	public ApiResponse deleteTenant(@RequestBody MasterTenantEntity masterTenantEntity) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					masterTenantService.deleteTenantById(masterTenantEntity), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"MasterTenantEntity Service exception : " + e.getLocalizedMessage());
		}
	}
}
