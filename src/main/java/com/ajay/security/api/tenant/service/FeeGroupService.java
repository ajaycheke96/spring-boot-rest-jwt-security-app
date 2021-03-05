package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public FeeGroup saveFeeGroup(FeeGroup feeGroup) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (feeGroup.getCreatedAt() == null)
			feeGroup.setCreatedAt(currentTimestamp);
		feeGroup.setUpdatedAt(currentTimestamp);
		return feeGroupRepository.save(feeGroup);
	}

	public String deleteOneFeeGroup(FeeGroup feeGroup) {
		String result = null;
		if (feeGroupRepository.existsById(feeGroup.getId())) {
			feeGroupRepository.delete(feeGroup);
			result = " FeeGroup deleted!";
		} else {
			result = "FeeGroup Not Found! or Already deleted!";
		}
		return result;
	}
}
