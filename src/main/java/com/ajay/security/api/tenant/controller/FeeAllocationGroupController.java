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

import com.ajay.security.api.tenant.entity.FeeAllocationGroup;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.FeeAllocationGroupService;

@RestController
@RequestMapping("/feeAllocationGroup")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeeAllocationGroupController {

	@Autowired
	private FeeAllocationGroupService feeAllocationGroupService;

	@GetMapping("/listAllFeeAllocationGroup")
	public ApiResponse getAllFeeAllocationGroup() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of FeeAllocationGroup",
					feeAllocationGroupService.getAllFeeAllocationGroups());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocationGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneFeeAllocationGroup(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeAllocationGroup",
					feeAllocationGroupService.getOneFeeAllocationGroup(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocationGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveFeeAllocationGroup")
	public ApiResponse saveFeeAllocationGroup(@RequestBody FeeAllocationGroup feeAllocationGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeAllocationGroup saved!",
					feeAllocationGroupService.saveFeeAllocationGroup(feeAllocationGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocationGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateFeeAllocationGroup")
	public ApiResponse updateFeeAllocationGroup(@RequestBody FeeAllocationGroup feeAllocationGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeAllocationGroup updated!",
					feeAllocationGroupService.saveFeeAllocationGroup(feeAllocationGroup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocationGroup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteFeeAllocationGroup")
	public ApiResponse deleteOneFeeAllocationGroup(@RequestBody FeeAllocationGroup feeAllocationGroup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					feeAllocationGroupService.deleteOneFeeAllocationGroup(feeAllocationGroup), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocationGroup Service exception : " + e.getLocalizedMessage());
		}
	}
}
