package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Batch;
import com.ajay.security.api.tenant.repository.BatchRepository;

@Service
public class BatchService {

	@Autowired
	private BatchRepository batchRepository;

	public List<Batch> getAllBatchs() {
		return batchRepository.findAll();
	}

	public Batch getOneBatch(Integer id) {
		return batchRepository.findById(id).get();
	}

	public String saveBatch(Batch batch) {
		return batchRepository.save(batch) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBatch(Batch batch) {
		return batchRepository.save(batch) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBatch(Integer id) {
		batchRepository.deleteById(id);
		return " successfully deleted!";
	}
}
