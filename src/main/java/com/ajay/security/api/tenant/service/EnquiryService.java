package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Enquiry;
import com.ajay.security.api.tenant.repository.EnquiryRepository;

@Service
@Transactional
public class EnquiryService {

	@Autowired
	private EnquiryRepository enquiryRepository;

	public List<Enquiry> getAllEnquirys() {
		return enquiryRepository.findAll();
	}

	public Enquiry getOneEnquiry(Integer id) {
		return enquiryRepository.findById(id).get();
	}

	public String saveEnquiry(Enquiry enquiry) {
		return enquiryRepository.save(enquiry) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEnquiry(Enquiry enquiry) {
		return enquiryRepository.save(enquiry) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneEnquiry(Integer id) {
		enquiryRepository.deleteById(id);
		return " successfully deleted!";
	}
}
