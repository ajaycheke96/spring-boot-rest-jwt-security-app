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

import com.ajay.security.api.tenant.entity.FeeAllocation;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.FeeAllocationService;

@RestController
@RequestMapping("/feeAllocation")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeeAllocationController {

	@Autowired
	private FeeAllocationService feeAllocationService;

	@GetMapping("/listAllFeeAllocation")
	public ApiResponse getAllFeeAllocation() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of FeeAllocation",
					feeAllocationService.getAllFeeAllocations());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocation Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneFeeAllocation(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeAllocation",
					feeAllocationService.getOneFeeAllocation(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveFeeAllocation")
	public ApiResponse saveFeeAllocation(@RequestBody FeeAllocation feeAllocation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeAllocation saved!",
					feeAllocationService.saveFeeAllocation(feeAllocation));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateFeeAllocation")
	public ApiResponse updateFeeAllocation(@RequestBody FeeAllocation feeAllocation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeAllocation updated!",
					feeAllocationService.saveFeeAllocation(feeAllocation));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocation Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteFeeAllocation")
	public ApiResponse deleteOneFeeAllocation(@RequestBody FeeAllocation feeAllocation) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					feeAllocationService.deleteOneFeeAllocation(feeAllocation), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeAllocation Service exception : " + e.getLocalizedMessage());
		}
	}
}
