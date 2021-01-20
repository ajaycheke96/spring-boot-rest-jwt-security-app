package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeGroup;
import com.ajay.security.api.tenant.repository.FeeGroupRepository;

@Service
@Transactional
public class FeeGroupService {

	@Autowired
	private FeeGroupRepository feeGroupRepository;

	public List<FeeGroup> getAllFeeGroups() {
		return feeGroupRepository.findAll();
	}

	public FeeGroup getOneFeeGroup(Integer id) {
		return feeGroupRepository.findById(id).get();
	}

	public String saveFeeGroup(FeeGroup feeGroup) {
		return feeGroupRepository.save(feeGroup) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateFeeGroup(FeeGroup feeGroup) {
		return feeGroupRepository.save(feeGroup) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneFeeGroup(Integer id) {
		feeGroupRepository.deleteById(id);
		return " successfully deleted!";
	}
}
