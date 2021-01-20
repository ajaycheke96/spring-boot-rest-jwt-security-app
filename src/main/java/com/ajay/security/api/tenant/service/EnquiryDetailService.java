package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EnquiryDetail;
import com.ajay.security.api.tenant.repository.EnquiryDetailRepository;

@Service
@Transactional
public class EnquiryDetailService {

	@Autowired
	private EnquiryDetailRepository enquiryDetailRepository;

	public List<EnquiryDetail> getAllEnquiryDetails() {
		return enquiryDetailRepository.findAll();
	}

	public EnquiryDetail getOneEnquiryDetail(Integer id) {
		return enquiryDetailRepository.findById(id).get();
	}

	public String saveEnquiryDetail(EnquiryDetail enquiryDetail) {
		return enquiryDetailRepository.save(enquiryDetail) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEnquiryDetail(EnquiryDetail enquiryDetail) {
		return enquiryDetailRepository.save(enquiryDetail) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneEnquiryDetail(Integer id) {
		enquiryDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
