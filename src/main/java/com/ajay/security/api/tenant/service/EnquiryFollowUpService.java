package com.ajay.security.api.tenant.service;

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

	public String saveEnquiryFollowUp(EnquiryFollowUp enquiryFollowUp) {
		return enquiryFollowUpRepository.save(enquiryFollowUp) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEnquiryFollowUp(EnquiryFollowUp enquiryFollowUp) {
		return enquiryFollowUpRepository.save(enquiryFollowUp) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEnquiryFollowUp(Integer id) {
		enquiryFollowUpRepository.deleteById(id);
		return " successfully deleted!";
	}
}
