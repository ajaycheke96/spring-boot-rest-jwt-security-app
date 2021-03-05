package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Admission saveAdmission(Admission admission) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (admission.getCreatedAt() == null)
			admission.setCreatedAt(currentTimestamp);
		admission.setUpdatedAt(currentTimestamp);
		return admissionRepository.save(admission);
	}

	public String deleteOneAdmission(Admission admission) {
		String result = null;
		if (admissionRepository.existsById(admission.getId())) {
			admissionRepository.delete(admission);
			result = " Admission deleted!";
		} else {
			result = "Admission Not Found! or Already deleted!";
		}
		return result;
	}
}
