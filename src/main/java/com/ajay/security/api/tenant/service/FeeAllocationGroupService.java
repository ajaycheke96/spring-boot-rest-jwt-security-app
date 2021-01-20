package com.ajay.security.api.tenant.service;

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

	public String saveFeeAllocationGroup(FeeAllocationGroup feeAllocationGroup) {
		return feeAllocationGroupRepository.save(feeAllocationGroup) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateFeeAllocationGroup(FeeAllocationGroup feeAllocationGroup) {
		return feeAllocationGroupRepository.save(feeAllocationGroup) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneFeeAllocationGroup(Integer id) {
		feeAllocationGroupRepository.deleteById(id);
		return " successfully deleted!";
	}
}
