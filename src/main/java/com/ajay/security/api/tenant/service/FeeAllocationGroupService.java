package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeAllocationGroup;
import com.ajay.security.api.tenant.repository.FeeAllocationGroupRepository;

@Service
@Transactional
public class FeeAllocationGroupService {

	@Autowired
	private FeeAllocationGroupRepository feeAllocationGroupRepository;

	public List<FeeAllocationGroup> getAllFeeAllocationGroups() {
		return feeAllocationGroupRepository.findAll();
	}

	public FeeAllocationGroup getOneFeeAllocationGroup(Integer id) {
		return feeAllocationGroupRepository.findById(id).get();
	}

	public FeeAllocationGroup saveFeeAllocationGroup(FeeAllocationGroup feeAllocationGroup) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (feeAllocationGroup.getCreatedAt() == null)
			feeAllocationGroup.setCreatedAt(currentTimestamp);
		feeAllocationGroup.setUpdatedAt(currentTimestamp);
		return feeAllocationGroupRepository.save(feeAllocationGroup);
	}

	public String deleteOneFeeAllocationGroup(FeeAllocationGroup feeAllocationGroup) {
		String result = null;
		if (feeAllocationGroupRepository.existsById(feeAllocationGroup.getId())) {
			feeAllocationGroupRepository.delete(feeAllocationGroup);
			result = " FeeAllocationGroup deleted!";
		} else {
			result = "FeeAllocationGroup Not Found! or Already deleted!";
		}
		return result;
	}
}
