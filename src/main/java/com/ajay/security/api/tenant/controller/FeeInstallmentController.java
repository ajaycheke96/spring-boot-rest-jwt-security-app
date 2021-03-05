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

import com.ajay.security.api.tenant.entity.FeeInstallment;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.FeeInstallmentService;

@RestController
@RequestMapping("/feeInstallment")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FeeInstallmentController {

	@Autowired
	private FeeInstallmentService feeInstallmentService;

	@GetMapping("/listAllFeeInstallment")
	public ApiResponse getAllFeeInstallment() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of FeeInstallment",
					feeInstallmentService.getAllFeeInstallments());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeInstallment Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneFeeInstallment(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeInstallment",
					feeInstallmentService.getOneFeeInstallment(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeInstallment Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveFeeInstallment")
	public ApiResponse saveFeeInstallment(@RequestBody FeeInstallment feeInstallment) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeInstallment saved!",
					feeInstallmentService.saveFeeInstallment(feeInstallment));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeInstallment Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateFeeInstallment")
	public ApiResponse updateFeeInstallment(@RequestBody FeeInstallment feeInstallment) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FeeInstallment updated!",
					feeInstallmentService.saveFeeInstallment(feeInstallment));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeInstallment Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteFeeInstallment")
	public ApiResponse deleteOneFeeInstallment(@RequestBody FeeInstallment feeInstallment) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					feeInstallmentService.deleteOneFeeInstallment(feeInstallment), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FeeInstallment Service exception : " + e.getLocalizedMessage());
		}
	}
}
