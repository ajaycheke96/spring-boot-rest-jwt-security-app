package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public EmployeeDocumentType saveEmployeeDocumentType(EmployeeDocumentType employeeDocumentType) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employeeDocumentType.getCreatedAt() == null)
			employeeDocumentType.setCreatedAt(currentTimestamp);
		employeeDocumentType.setUpdatedAt(currentTimestamp);
		return employeeDocumentTypeRepository.save(employeeDocumentType);
	}

	public String deleteOneEmployeeDocumentType(EmployeeDocumentType employeeDocumentType) {
		String result = null;
		if (employeeDocumentTypeRepository.existsById(employeeDocumentType.getId())) {
			employeeDocumentTypeRepository.delete(employeeDocumentType);
			result = " EmployeeDocumentType deleted!";
		} else {
			result = "EmployeeDocumentType Not Found! or Already deleted!";
		}
		return result;
	}
}
