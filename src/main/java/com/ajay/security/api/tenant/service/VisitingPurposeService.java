package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VisitingPurpose;
import com.ajay.security.api.tenant.repository.VisitingPurposeRepository;

@Service
@Transactional
public class VisitingPurposeService {

	@Autowired
	private VisitingPurposeRepository visitingPurposeRepository;

	public List<VisitingPurpose> getAllVisitingPurposes() {
		return visitingPurposeRepository.findAll();
	}

	public VisitingPurpose getOneVisitingPurpose(Integer id) {
		return visitingPurposeRepository.findById(id).get();
	}

	public String saveVisitingPurpose(VisitingPurpose visitingPurpose) {
		return visitingPurposeRepository.save(visitingPurpose) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVisitingPurpose(VisitingPurpose visitingPurpose) {
		return visitingPurposeRepository.save(visitingPurpose) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVisitingPurpose(Integer id) {
		visitingPurposeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
