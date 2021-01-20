package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeConcessionDetail;
import com.ajay.security.api.tenant.repository.FeeConcessionDetailRepository;

@Service
@Transactional
public class FeeConcessionDetailService {

	@Autowired
	private FeeConcessionDetailRepository feeConcessionDetailRepository;

	public List<FeeConcessionDetail> getAllFeeConcessionDetails() {
		return feeConcessionDetailRepository.findAll();
	}

	public FeeConcessionDetail getOneFeeConcessionDetail(Integer id) {
		return feeConcessionDetailRepository.findById(id).get();
	}

	public String saveFeeConcessionDetail(FeeConcessionDetail feeConcessionDetail) {
		return feeConcessionDetailRepository.save(feeConcessionDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateFeeConcessionDetail(FeeConcessionDetail feeConcessionDetail) {
		return feeConcessionDetailRepository.save(feeConcessionDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneFeeConcessionDetail(Integer id) {
		feeConcessionDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
