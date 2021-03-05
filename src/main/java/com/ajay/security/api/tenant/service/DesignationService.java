package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Designation;
import com.ajay.security.api.tenant.repository.DesignationRepository;

@Service
public class DesignationService {

	@Autowired
	private DesignationRepository designationRepository;

	public List<Designation> getAllDesignations() {
		return designationRepository.findAll();
	}

	public Designation getOneDesignation(Integer id) {
		return designationRepository.findById(id).get();
	}

	public Designation saveDesignation(Designation designation) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (designation.getCreatedAt() == null)
			designation.setCreatedAt(currentTimestamp);
		designation.setUpdatedAt(currentTimestamp);
		return designationRepository.save(designation);
	}

	public String deleteOneDesignation(Designation designation) {
		String result = null;
		if (designationRepository.existsById(designation.getId())) {
			designationRepository.delete(designation);
			result = " Designation deleted!";
		} else {
			result = "Designation Not Found! or Already deleted!";
		}
		return result;
	}
}
