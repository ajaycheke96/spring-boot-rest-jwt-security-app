package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeConcession;
import com.ajay.security.api.tenant.repository.FeeConcessionRepository;

@Service
@Transactional
public class FeeConcessionService {

	@Autowired
	private FeeConcessionRepository feeConcessionRepository;

	public List<FeeConcession> getAllFeeConcessions() {
		return feeConcessionRepository.findAll();
	}

	public FeeConcession getOneFeeConcession(Integer id) {
		return feeConcessionRepository.findById(id).get();
	}

	public String saveFeeConcession(FeeConcession feeConcession) {
		return feeConcessionRepository.save(feeConcession) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateFeeConcession(FeeConcession feeConcession) {
		return feeConcessionRepository.save(feeConcession) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneFeeConcession(Integer id) {
		feeConcessionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
