package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.ComplaintType;
import com.ajay.security.api.tenant.repository.ComplaintTypeRepository;

@Service
public class ComplaintTypeService {

	@Autowired
	private ComplaintTypeRepository complaintTypeRepository;

	public List<ComplaintType> getAllComplaintTypes() {
		return complaintTypeRepository.findAll();
	}

	public ComplaintType getOneComplaintType(Integer id) {
		return complaintTypeRepository.findById(id).get();
	}

	public ComplaintType saveComplaintType(ComplaintType complaintType) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (complaintType.getCreatedAt() == null)
			complaintType.setCreatedAt(currentTimestamp);
		complaintType.setUpdatedAt(currentTimestamp);
		return complaintTypeRepository.save(complaintType);
	}

	public String deleteOneComplaintType(ComplaintType complaintType) {
		String result = null;
		if (complaintTypeRepository.existsById(complaintType.getId())) {
			complaintTypeRepository.delete(complaintType);
			result = " ComplaintType deleted!";
		} else {
			result = "ComplaintType Not Found! or Already deleted!";
		}
		return result;
	}
}
