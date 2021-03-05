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

import com.ajay.security.api.tenant.entity.BloodGroup;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.BloodGroupService;

@RestController
@RequestMapping("/bloodGroup")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BloodGroupController {

	@Autowired
	private BloodGroupService bloodGroupService;

	@GetMapping("/listAllBloodGroup")
	public ApiResponse getAllBloodGroup() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of BloodGroup",
					bloodGroupService.getAllBloodGroups());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BloodGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneBloodGroup(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "BloodGroup",
					bloodGroupService.getOneBloodGroup(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BloodGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveBloodGroup")
	public ApiResponse saveBloodGroup(@RequestBody BloodGroup bloodGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "BloodGroup saved!",
					bloodGroupService.saveBloodGroup(bloodGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BloodGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateBloodGroup")
	public ApiResponse updateBloodGroup(@RequestBody BloodGroup bloodGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "BloodGroup updated!",
					bloodGroupService.saveBloodGroup(bloodGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BloodGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteBloodGroup")
	public ApiResponse deleteOneBloodGroup(@RequestBody BloodGroup bloodGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, bloodGroupService.deleteOneBloodGroup(bloodGroup),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"BloodGroup Service exception : " + e.getLocalizedMessage());
		}
	}
}
