package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CommunicationEmployee;
import com.ajay.security.api.tenant.repository.CommunicationEmployeeRepository;

@Service
public class CommunicationEmployeeService {

	@Autowired
	private CommunicationEmployeeRepository communicationEmployeeRepository;

	public List<CommunicationEmployee> getAllCommunicationEmployees() {
		return communicationEmployeeRepository.findAll();
	}

	public CommunicationEmployee getOneCommunicationEmployee(Integer id) {
		return communicationEmployeeRepository.findById(id).get();
	}

	public String saveCommunicationEmployee(CommunicationEmployee communicationEmployee) {
		return communicationEmployeeRepository.save(communicationEmployee) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateCommunicationEmployee(CommunicationEmployee communicationEmployee) {
		return communicationEmployeeRepository.save(communicationEmployee) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCommunicationEmployee(Integer id) {
		communicationEmployeeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
