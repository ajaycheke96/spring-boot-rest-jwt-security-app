package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CommunicationDepartment;
import com.ajay.security.api.tenant.repository.CommunicationDepartmentRepository;

@Service
public class CommunicationDepartmentService {

	@Autowired
	private CommunicationDepartmentRepository communicationDepartmentRepository;

	public List<CommunicationDepartment> getAllCommunicationDepartments() {
		return communicationDepartmentRepository.findAll();
	}

	public CommunicationDepartment getOneCommunicationDepartment(Integer id) {
		return communicationDepartmentRepository.findById(id).get();
	}

	public String saveCommunicationDepartment(CommunicationDepartment communicationDepartment) {
		return communicationDepartmentRepository.save(communicationDepartment) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateCommunicationDepartment(CommunicationDepartment communicationDepartment) {
		return communicationDepartmentRepository.save(communicationDepartment) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCommunicationDepartment(Integer id) {
		communicationDepartmentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
