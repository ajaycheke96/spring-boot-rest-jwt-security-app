package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EnquiryFollowUp;
import com.ajay.security.api.tenant.repository.EnquiryFollowUpRepository;

@Service
@Transactional
public class EnquiryFollowUpService {

	@Autowired
	private EnquiryFollowUpRepository enquiryFollowUpRepository;

	public List<EnquiryFollowUp> getAllEnquiryFollowUps() {
		return enquiryFollowUpRepository.findAll();
	}

	public EnquiryFollowUp getOneEnquiryFollowUp(Integer id) {
		return enquiryFollowUpRepository.findById(id).get();
	}

	public EnquiryFollowUp saveEnquiryFollowUp(EnquiryFollowUp enquiryFollowUp) {
		Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
		if (enquiryFollowUp.getCreatedAt() == null)
			enquiryFollowUp.setCreatedAt(currentTimeStamp);
		enquiryFollowUp.setUpdatedAt(currentTimeStamp);
		return enquiryFollowUpRepository.save(enquiryFollowUp);
	}

	public String deleteOneEnquiryFollowUp(EnquiryFollowUp enquiryFollowUp) {
		String result = null;
		if (enquiryFollowUpRepository.existsById(enquiryFollowUp.getId())) {
			enquiryFollowUpRepository.delete(enquiryFollowUp);
			result = " EnquiryFollowUp deleted!";
		} else {
			result = "EnquiryFollowUp Not Found! or Already deleted!";
		}
		return result;
	}
}
