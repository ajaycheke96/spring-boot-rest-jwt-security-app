package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Complaint;
import com.ajay.security.api.tenant.repository.ComplaintRepository;

@Service
public class ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;

	public List<Complaint> getAllComplaints() {
		return complaintRepository.findAll();
	}

	public Complaint getOneComplaint(Integer id) {
		return complaintRepository.findById(id).get();
	}

	public Complaint saveComplaint(Complaint complaint) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (complaint.getCreatedAt() == null)
			complaint.setCreatedAt(currentTimestamp);
		complaint.setUpdatedAt(currentTimestamp);
		return complaintRepository.save(complaint);
	}

	public String deleteOneComplaint(Complaint complaint) {
		String result = null;
		if (complaintRepository.existsById(complaint.getId())) {
			complaintRepository.delete(complaint);
			result = "Complaint updated!";
		} else {
			result = "Complaint not found! or Already deleted!";
		}
		return result;
	}
}
