package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Batch saveBatch(Batch batch) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (batch.getCreatedAt() == null)
			batch.setCreatedAt(currentTimestamp);
		batch.setUpdatedAt(currentTimestamp);
		return batchRepository.save(batch);
	}

	public String deleteOneBatch(Batch batch) {
		String result = null;
		if (batchRepository.existsById(batch.getId())) {
			batchRepository.delete(batch);
			result = " Batch deleted!";
		} else {
			result = "Batch Not Found! or Already deleted!";
		}
		return result;
	}
}
