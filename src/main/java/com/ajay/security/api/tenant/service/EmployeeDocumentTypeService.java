package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeDocumentType;
import com.ajay.security.api.tenant.repository.EmployeeDocumentTypeRepository;

@Service
@Transactional
public class EmployeeDocumentTypeService {

	@Autowired
	private EmployeeDocumentTypeRepository employeeDocumentTypeRepository;

	public List<EmployeeDocumentType> getAllEmployeeDocumentTypes() {
		return employeeDocumentTypeRepository.findAll();
	}

	public EmployeeDocumentType getOneEmployeeDocumentType(Integer id) {
		return employeeDocumentTypeRepository.findById(id).get();
	}

	public String saveEmployeeDocumentType(EmployeeDocumentType employeeDocumentType) {
		return employeeDocumentTypeRepository.save(employeeDocumentType) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeDocumentType(EmployeeDocumentType employeeDocumentType) {
		return employeeDocumentTypeRepository.save(employeeDocumentType) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeDocumentType(Integer id) {
		employeeDocumentTypeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
