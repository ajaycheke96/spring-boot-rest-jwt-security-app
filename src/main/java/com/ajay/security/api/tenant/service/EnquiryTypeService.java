package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public EnquiryType saveEnquiryType(EnquiryType enquiryType) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (enquiryType.getCreatedAt() == null)
			enquiryType.setCreatedAt(currentTimestamp);
		enquiryType.setUpdatedAt(currentTimestamp);
		return enquiryTypeRepository.save(enquiryType);
	}

	public String deleteOneEnquiryType(EnquiryType enquiryType) {
		String result = null;
		if (enquiryTypeRepository.existsById(enquiryType.getId())) {
			enquiryTypeRepository.delete(enquiryType);
			result = " EnquiryType deleted!";
		} else {
			result = "EnquiryType Not Found! or Already deleted!";
		}
		return result;
	}
}
