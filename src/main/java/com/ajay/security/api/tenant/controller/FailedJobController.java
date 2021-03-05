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

import com.ajay.security.api.tenant.entity.FailedJob;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.FailedJobService;

@RestController
@RequestMapping("/failedJob")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FailedJobController {

	@Autowired
	private FailedJobService failedJobService;

	@GetMapping("/listAllFailedJob")
	public ApiResponse getAllFailedJob() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of FailedJob",
					failedJobService.getAllFailedJobs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FailedJob Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneFailedJob(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FailedJob", failedJobService.getOneFailedJob(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FailedJob Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveFailedJob")
	public ApiResponse saveFailedJob(@RequestBody FailedJob failedJob) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FailedJob saved!",
					failedJobService.saveFailedJob(failedJob));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FailedJob Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateFailedJob")
	public ApiResponse updateFailedJob(@RequestBody FailedJob failedJob) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FailedJob updated!",
					failedJobService.saveFailedJob(failedJob));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FailedJob Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteFailedJob")
	public ApiResponse deleteOneFailedJob(@RequestBody FailedJob failedJob) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, failedJobService.deleteOneFailedJob(failedJob),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FailedJob Service exception : " + e.getLocalizedMessage());
		}
	}
}
