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

import com.ajay.security.api.tenant.entity.FeeHead;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.FeeHeadService;

@RestController
@RequestMapping("/feeHead")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeeHeadController {

	@Autowired
	private FeeHeadService feeHeadService;

	@GetMapping("/listAllFeeHead")
	public ApiResponse getAllFeeHead() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of FeeHead", feeHeadService.getAllFeeHeads());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeHead Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneFeeHead(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeHead", feeHeadService.getOneFeeHead(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeHead Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveFeeHead")
	public ApiResponse saveFeeHead(@RequestBody FeeHead feeHead) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeHead saved!",
					feeHeadService.saveFeeHead(feeHead));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeHead Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateFeeHead")
	public ApiResponse updateFeeHead(@RequestBody FeeHead feeHead) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeHead updated!",
					feeHeadService.saveFeeHead(feeHead));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeHead Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteFeeHead")
	public ApiResponse deleteOneFeeHead(@RequestBody FeeHead feeHead) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, feeHeadService.deleteOneFeeHead(feeHead), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeHead Service exception : " + e.getLocalizedMessage());
		}
	}
}
