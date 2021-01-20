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

	public String saveEnquirySource(EnquirySource enquirySource) {
		return enquirySourceRepository.save(enquirySource) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEnquirySource(EnquirySource enquirySource) {
		return enquirySourceRepository.save(enquirySource) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEnquirySource(Integer id) {
		enquirySourceRepository.deleteById(id);
		return " successfully deleted!";
	}
}
