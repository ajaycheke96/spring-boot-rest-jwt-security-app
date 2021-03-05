package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public FailedJob saveFailedJob(FailedJob failedJob) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		failedJob.setFailedAt(currentTimestamp);
		return failedJobRepository.save(failedJob);
	}

	public String deleteOneFailedJob(FailedJob failedJob) {
		String result = null;
		if (failedJobRepository.existsById(failedJob.getId())) {
			failedJobRepository.delete(failedJob);
			result = " FailedJob deleted!";
		} else {
			result = "FailedJob Not Found! or Already deleted!";
		}
		return result;
	}
}
