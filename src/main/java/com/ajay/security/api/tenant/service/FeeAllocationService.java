package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeAllocation;
import com.ajay.security.api.tenant.repository.FeeAllocationRepository;

@Service
@Transactional
public class FeeAllocationService {

	@Autowired
	private FeeAllocationRepository feeAllocationRepository;

	public List<FeeAllocation> getAllFeeAllocations() {
		return feeAllocationRepository.findAll();
	}

	public FeeAllocation getOneFeeAllocation(Integer id) {
		return feeAllocationRepository.findById(id).get();
	}

	public FeeAllocation saveFeeAllocation(FeeAllocation feeAllocation) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (feeAllocation.getCreatedAt() == null)
			feeAllocation.setCreatedAt(currentTimestamp);
		feeAllocation.setUpdatedAt(currentTimestamp);
		return feeAllocationRepository.save(feeAllocation);
	}

	public String deleteOneFeeAllocation(FeeAllocation feeAllocation) {
		String result = null;
		if (feeAllocationRepository.existsById(feeAllocation.getId())) {
			feeAllocationRepository.delete(feeAllocation);
			result = " FeeAllocation deleted!";
		} else {
			result = "FeeAllocation Not Found! or Already deleted!";
		}
		return result;
	}
}
