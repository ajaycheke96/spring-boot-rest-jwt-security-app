package com.ajay.security.api.tenant.service;

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

	public String saveDesignation(Designation designation) {
		return designationRepository.save(designation) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateDesignation(Designation designation) {
		return designationRepository.save(designation) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneDesignation(Integer id) {
		designationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
