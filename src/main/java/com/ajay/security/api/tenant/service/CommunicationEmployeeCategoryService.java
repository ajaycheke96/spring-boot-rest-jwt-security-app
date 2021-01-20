package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CommunicationEmployeeCategory;
import com.ajay.security.api.tenant.repository.CommunicationEmployeeCategoryRepository;

@Service
public class CommunicationEmployeeCategoryService {

	@Autowired
	private CommunicationEmployeeCategoryRepository communicationEmployeeCategoryRepository;

	public List<CommunicationEmployeeCategory> getAllCommunicationEmployeeCategorys() {
		return communicationEmployeeCategoryRepository.findAll();
	}

	public CommunicationEmployeeCategory getOneCommunicationEmployeeCategory(Integer id) {
		return communicationEmployeeCategoryRepository.findById(id).get();
	}

	public String saveCommunicationEmployeeCategory(CommunicationEmployeeCategory communicationEmployeeCategory) {
		return communicationEmployeeCategoryRepository.save(communicationEmployeeCategory) != null
				? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateCommunicationEmployeeCategory(CommunicationEmployeeCategory communicationEmployeeCategory) {
		return communicationEmployeeCategoryRepository.save(communicationEmployeeCategory) != null
				? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCommunicationEmployeeCategory(Integer id) {
		communicationEmployeeCategoryRepository.deleteById(id);
		return " successfully deleted!";
	}
}
