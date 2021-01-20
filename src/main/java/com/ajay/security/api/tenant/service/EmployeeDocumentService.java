package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.EmployeeDocument;
import com.ajay.security.api.tenant.repository.EmployeeDocumentRepository;

@Service
public class EmployeeDocumentService {

	@Autowired
	private EmployeeDocumentRepository employeeDocumentRepository;

	public List<EmployeeDocument> getAllEmployeeDocuments() {
		return employeeDocumentRepository.findAll();
	}

	public EmployeeDocument getOneEmployeeDocument(Integer id) {
		return employeeDocumentRepository.findById(id).get();
	}

	public String saveEmployeeDocument(EmployeeDocument employeeDocument) {
		return employeeDocumentRepository.save(employeeDocument) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeDocument(EmployeeDocument employeeDocument) {
		return employeeDocumentRepository.save(employeeDocument) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeDocument(Integer id) {
		employeeDocumentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
