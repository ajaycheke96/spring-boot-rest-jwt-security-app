package com.ajay.security.api.tenant.service;

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

	public String saveComplaint(Complaint complaint) {
		return complaintRepository.save(complaint) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateComplaint(Complaint complaint) {
		return complaintRepository.save(complaint) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneComplaint(Integer id) {
		complaintRepository.deleteById(id);
		return " successfully deleted!";
	}
}
