package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Enquiry saveEnquiry(Enquiry enquiry) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (enquiry.getCreatedAt() == null)
			enquiry.setCreatedAt(currentTimestamp);
		enquiry.setUpdatedAt(currentTimestamp);
		return enquiryRepository.save(enquiry);
	}

	public String deleteOneEnquiry(Enquiry enquiry) {
		String result = null;
		if (enquiryRepository.existsById(enquiry.getId())) {
			enquiryRepository.delete(enquiry);
			result = " Enquiry deleted!";
		} else {
			result = "Enquiry Not Found! or Already deleted!";
		}
		return result;
	}
}
