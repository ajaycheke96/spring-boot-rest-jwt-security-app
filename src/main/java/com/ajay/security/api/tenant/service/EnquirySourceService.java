package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EnquirySource;
import com.ajay.security.api.tenant.repository.EnquirySourceRepository;

@Service
@Transactional
public class EnquirySourceService {

	@Autowired
	private EnquirySourceRepository enquirySourceRepository;

	public List<EnquirySource> getAllEnquirySources() {
		return enquirySourceRepository.findAll();
	}

	public EnquirySource getOneEnquirySource(Integer id) {
		return enquirySourceRepository.findById(id).get();
	}

	public EnquirySource saveEnquirySource(EnquirySource enquirySource) {
		return enquirySourceRepository.save(enquirySource);
	}

	public String deleteOneEnquirySource(EnquirySource enquirySource) {
		enquirySourceRepository.delete(enquirySource);
		return " successfully deleted!";
	}
}
