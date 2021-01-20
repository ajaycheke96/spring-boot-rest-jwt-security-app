package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.PayHead;
import com.ajay.security.api.tenant.repository.PayHeadRepository;

@Service
@Transactional
public class PayHeadService {

	@Autowired
	private PayHeadRepository payHeadRepository;

	public List<PayHead> getAllPayHeads() {
		return payHeadRepository.findAll();
	}

	public PayHead getOnePayHead(Integer id) {
		return payHeadRepository.findById(id).get();
	}

	public String savePayHead(PayHead payHead) {
		return payHeadRepository.save(payHead) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updatePayHead(PayHead payHead) {
		return payHeadRepository.save(payHead) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOnePayHead(Integer id) {
		payHeadRepository.deleteById(id);
		return " successfully deleted!";
	}
}
