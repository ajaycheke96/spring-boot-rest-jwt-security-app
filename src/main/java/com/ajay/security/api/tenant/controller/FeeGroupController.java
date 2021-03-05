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

import com.ajay.security.api.tenant.entity.FeeGroup;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.FeeGroupService;

@RestController
@RequestMapping("/feeGroup")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeeGroupController {

	@Autowired
	private FeeGroupService feeGroupService;

	@GetMapping("/listAllFeeGroup")
	public ApiResponse getAllFeeGroup() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of FeeGroup",
					feeGroupService.getAllFeeGroups());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneFeeGroup(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeGroup", feeGroupService.getOneFeeGroup(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveFeeGroup")
	public ApiResponse saveFeeGroup(@RequestBody FeeGroup feeGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeGroup saved!",
					feeGroupService.saveFeeGroup(feeGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateFeeGroup")
	public ApiResponse updateFeeGroup(@RequestBody FeeGroup feeGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeGroup updated!",
					feeGroupService.saveFeeGroup(feeGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteFeeGroup")
	public ApiResponse deleteOneFeeGroup(@RequestBody FeeGroup feeGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, feeGroupService.deleteOneFeeGroup(feeGroup), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeGroup Service exception : " + e.getLocalizedMessage());
		}
	}
}
