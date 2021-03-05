package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeGroup;
import com.ajay.security.api.tenant.repository.EmployeeGroupRepository;

@Service
@Transactional
public class EmployeeGroupService {

	@Autowired
	private EmployeeGroupRepository employeeGroupRepository;

	public List<EmployeeGroup> getAllEmployeeGroups() {
		return employeeGroupRepository.findAll();
	}

	public EmployeeGroup getOneEmployeeGroup(Integer id) {
		return employeeGroupRepository.findById(id).get();
	}

	public EmployeeGroup saveEmployeeGroup(EmployeeGroup employeeGroup) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employeeGroup.getCreatedAt() == null)
			employeeGroup.setCreatedAt(currentTimestamp);
		employeeGroup.setUpdatedAt(currentTimestamp);
		return employeeGroupRepository.save(employeeGroup);
	}

	public String deleteOneEmployeeGroup(EmployeeGroup employeeGroup) {
		String result = null;
		if (employeeGroupRepository.existsById(employeeGroup.getId())) {
			employeeGroupRepository.delete(employeeGroup);
			result = " EmployeeGroup deleted!";
		} else {
			result = "EmployeeGroup Not Found! or Already deleted!";
		}
		return result;
	}
}
