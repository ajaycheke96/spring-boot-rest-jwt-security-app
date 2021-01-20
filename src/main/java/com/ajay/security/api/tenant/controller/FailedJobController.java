package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.FailedJob;
import com.ajay.security.api.tenant.service.FailedJobService;

@RestController
@RequestMapping("/failedJob")
public class FailedJobController {

	@Autowired
	private FailedJobService failedJobService;

	@GetMapping("/all")
	public List<FailedJob> getAllFailedJob() {
		return failedJobService.getAllFailedJobs();
	}

	@GetMapping("/one/{id}")
	public FailedJob getOneFailedJob(@PathVariable Integer id) {
		return failedJobService.getOneFailedJob(id);
	}

	@PostMapping("/save")
	public String saveFailedJob(@RequestBody FailedJob failedJob) {
		return failedJobService.saveFailedJob(failedJob);
	}

	@PutMapping("/update")
	public String updateFailedJob(@RequestBody FailedJob failedJob) {
		return failedJobService.updateFailedJob(failedJob);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFailedJob(@PathVariable Integer id) {
		return failedJobService.deleteOneFailedJob(id);
	}
}
