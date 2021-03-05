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

import com.ajay.security.api.tenant.entity.Batch;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.BatchService;

@RestController
@RequestMapping("/batch")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BatchController {

	@Autowired
	private BatchService batchService;

	@GetMapping("/listAllBatch")
	public ApiResponse getAllBatch() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Batch", batchService.getAllBatchs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Batch Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneBatch(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Batch", batchService.getOneBatch(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Batch Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveBatch")
	public ApiResponse saveBatch(@RequestBody Batch batch) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Batch saved!", batchService.saveBatch(batch));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Batch Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateBatch")
	public ApiResponse updateBatch(@RequestBody Batch batch) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Batch updated!", batchService.saveBatch(batch));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Batch Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteBatch")
	public ApiResponse deleteOneBatch(@RequestBody Batch batch) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, batchService.deleteOneBatch(batch), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Batch Service exception : " + e.getLocalizedMessage());
		}
	}
}
