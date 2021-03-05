package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (enquirySource.getCreatedAt() == null)
			enquirySource.setCreatedAt(currentTimestamp);
		enquirySource.setUpdatedAt(currentTimestamp);
		return enquirySourceRepository.save(enquirySource);
	}

	public String deleteOneEnquirySource(EnquirySource enquirySource) {
		String result = null;
		if (enquirySourceRepository.existsById(enquirySource.getId())) {
			enquirySourceRepository.delete(enquirySource);
			result = " EnquirySource deleted!";
		} else {
			result = "EnquirySource Not Found! or Already deleted!";
		}
		return result;
	}
}
