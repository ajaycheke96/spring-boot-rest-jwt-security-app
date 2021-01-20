package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.ComplaintType;
import com.ajay.security.api.tenant.repository.ComplaintTypeRepository;

@Service
public class ComplaintTypeService {

	@Autowired
	private ComplaintTypeRepository complaintTypeRepository;

	public List<ComplaintType> getAllComplaintTypes() {
		return complaintTypeRepository.findAll();
	}

	public ComplaintType getOneComplaintType(Integer id) {
		return complaintTypeRepository.findById(id).get();
	}

	public String saveComplaintType(ComplaintType complaintType) {
		return complaintTypeRepository.save(complaintType) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateComplaintType(ComplaintType complaintType) {
		return complaintTypeRepository.save(complaintType) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneComplaintType(Integer id) {
		complaintTypeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
