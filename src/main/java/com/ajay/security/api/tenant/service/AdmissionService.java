package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Admission;
import com.ajay.security.api.tenant.repository.AdmissionRepository;

@Service
public class AdmissionService {

	@Autowired
	private AdmissionRepository admissionRepository;

	public List<Admission> getAllAdmissions() {
		return admissionRepository.findAll();
	}

	public Admission getOneAdmission(Integer id) {
		return admissionRepository.findById(id).get();
	}

	public String saveAdmission(Admission admission) {
		return admissionRepository.save(admission) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateAdmission(Admission admission) {
		return admissionRepository.save(admission) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneAdmission(Integer id) {
		admissionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
