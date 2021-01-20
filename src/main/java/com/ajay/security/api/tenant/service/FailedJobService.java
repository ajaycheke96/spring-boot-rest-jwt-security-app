package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FailedJob;
import com.ajay.security.api.tenant.repository.FailedJobRepository;

@Service
@Transactional
public class FailedJobService {

	@Autowired
	private FailedJobRepository failedJobRepository;

	public List<FailedJob> getAllFailedJobs() {
		return failedJobRepository.findAll();
	}

	public FailedJob getOneFailedJob(Integer id) {
		return failedJobRepository.findById(id).get();
	}

	public String saveFailedJob(FailedJob failedJob) {
		return failedJobRepository.save(failedJob) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateFailedJob(FailedJob failedJob) {
		return failedJobRepository.save(failedJob) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneFailedJob(Integer id) {
		failedJobRepository.deleteById(id);
		return " successfully deleted!";
	}
}
