package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BloodGroup;
import com.ajay.security.api.tenant.repository.BloodGroupRepository;

@Service
public class BloodGroupService {

	@Autowired
	private BloodGroupRepository bloodGroupRepository;

	public List<BloodGroup> getAllBloodGroups() {
		return bloodGroupRepository.findAll();
	}

	public BloodGroup getOneBloodGroup(Integer id) {
		return bloodGroupRepository.findById(id).get();
	}

	public BloodGroup saveBloodGroup(BloodGroup bloodGroup) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (bloodGroup.getCreatedAt() == null)
			bloodGroup.setCreatedAt(currentTimestamp);
		bloodGroup.setUpdatedAt(currentTimestamp);
		return bloodGroupRepository.save(bloodGroup);
	}

	public String deleteOneBloodGroup(BloodGroup bloodGroup) {
		String result = null;
		if (bloodGroupRepository.existsById(bloodGroup.getId())) {
			bloodGroupRepository.delete(bloodGroup);
			result = " BloodGroup deleted!";
		} else {
			result = "BloodGroup Not Found! or Already deleted!";
		}
		return result;
	}
}
