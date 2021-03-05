package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public PayHead savePayHead(PayHead payHead) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (payHead.getCreatedAt() == null)
			payHead.setCreatedAt(currentTimestamp);
		payHead.setUpdatedAt(currentTimestamp);
		return payHeadRepository.save(payHead);
	}

	public String deleteOnePayHead(PayHead payHead) {
		String result = null;
		if (payHeadRepository.existsById(payHead.getId())) {
			payHeadRepository.delete(payHead);
			result = "PayHead deleted!";
		} else {
			result = "PayHead not found! Or Already deleted!";
		}
		return result;
	}
}
