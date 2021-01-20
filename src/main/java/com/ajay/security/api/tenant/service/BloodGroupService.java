package com.ajay.security.api.tenant.service;

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

	public String saveBloodGroup(BloodGroup bloodGroup) {
		return bloodGroupRepository.save(bloodGroup) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBloodGroup(BloodGroup bloodGroup) {
		return bloodGroupRepository.save(bloodGroup) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBloodGroup(Integer id) {
		bloodGroupRepository.deleteById(id);
		return " successfully deleted!";
	}
}
