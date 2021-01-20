package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Job;
import com.ajay.security.api.tenant.repository.JobRepository;

@Service
@Transactional
public class JobService {

	@Autowired
	private JobRepository jobRepository;

	public List<Job> getAllJobs() {
		return jobRepository.findAll();
	}

	public Job getOneJob(Integer id) {
		return jobRepository.findById(id).get();
	}

	public String saveJob(Job job) {
		return jobRepository.save(job) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateJob(Job job) {
		return jobRepository.save(job) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneJob(Integer id) {
		jobRepository.deleteById(id);
		return " successfully deleted!";
	}
}
