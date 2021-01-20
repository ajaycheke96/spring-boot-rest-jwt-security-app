package com.ajay.security.api.tenant.service;

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

	public String saveFeeAllocation(FeeAllocation feeAllocation) {
		return feeAllocationRepository.save(feeAllocation) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateFeeAllocation(FeeAllocation feeAllocation) {
		return feeAllocationRepository.save(feeAllocation) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneFeeAllocation(Integer id) {
		feeAllocationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
