package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EnquiryType;
import com.ajay.security.api.tenant.repository.EnquiryTypeRepository;

@Service
@Transactional
public class EnquiryTypeService {

	@Autowired
	private EnquiryTypeRepository enquiryTypeRepository;

	public List<EnquiryType> getAllEnquiryTypes() {
		return enquiryTypeRepository.findAll();
	}

	public EnquiryType getOneEnquiryType(Integer id) {
		return enquiryTypeRepository.findById(id).get();
	}

	public String saveEnquiryType(EnquiryType enquiryType) {
		return enquiryTypeRepository.save(enquiryType) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEnquiryType(EnquiryType enquiryType) {
		return enquiryTypeRepository.save(enquiryType) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEnquiryType(Integer id) {
		enquiryTypeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
