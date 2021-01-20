package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeHead;
import com.ajay.security.api.tenant.repository.FeeHeadRepository;

@Service
@Transactional
public class FeeHeadService {

	@Autowired
	private FeeHeadRepository feeHeadRepository;

	public List<FeeHead> getAllFeeHeads() {
		return feeHeadRepository.findAll();
	}

	public FeeHead getOneFeeHead(Integer id) {
		return feeHeadRepository.findById(id).get();
	}

	public String saveFeeHead(FeeHead feeHead) {
		return feeHeadRepository.save(feeHead) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateFeeHead(FeeHead feeHead) {
		return feeHeadRepository.save(feeHead) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneFeeHead(Integer id) {
		feeHeadRepository.deleteById(id);
		return " successfully deleted!";
	}
}
