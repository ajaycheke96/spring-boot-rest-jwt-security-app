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

import com.ajay.security.api.tenant.entity.Job;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.JobService;

@RestController
@RequestMapping("/job")
@CrossOrigin(origins = "*", maxAge = 3600)
public class JobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/listAllJob")
	public ApiResponse getAllJob() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Job", jobService.getAllJobs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Job Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneJob(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Job", jobService.getOneJob(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Job Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveJob")
	public ApiResponse saveJob(@RequestBody Job job) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Job saved!", jobService.saveJob(job));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Job Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateJob")
	public ApiResponse updateJob(@RequestBody Job job) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Job updated!", jobService.saveJob(job));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Job Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteJob")
	public ApiResponse deleteOneJob(@RequestBody Job job) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, jobService.deleteOneJob(job), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Job Service exception : " + e.getLocalizedMessage());
		}
	}
}
