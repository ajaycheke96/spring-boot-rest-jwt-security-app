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

import com.ajay.security.api.tenant.entity.Job;
import com.ajay.security.api.tenant.service.JobService;

@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;

	@GetMapping("/all")
	public List<Job> getAllJob() {
		return jobService.getAllJobs();
	}

	@GetMapping("/one/{id}")
	public Job getOneJob(@PathVariable Integer id) {
		return jobService.getOneJob(id);
	}

	@PostMapping("/save")
	public String saveJob(@RequestBody Job job) {
		return jobService.saveJob(job);
	}

	@PutMapping("/update")
	public String updateJob(@RequestBody Job job) {
		return jobService.updateJob(job);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneJob(@PathVariable Integer id) {
		return jobService.deleteOneJob(id);
	}
}
