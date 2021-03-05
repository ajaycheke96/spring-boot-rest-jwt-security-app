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

	public Job saveJob(Job job) {
		return jobRepository.save(job);
	}

	public String deleteOneJob(Job job) {
		String result = null;
		if (jobRepository.existsById(job.getId())) {
			jobRepository.delete(job);
			result = " Job deleted!";
		} else {
			result = "Job Not Found! or Already deleted!";
		}
		return result;
	}
}
