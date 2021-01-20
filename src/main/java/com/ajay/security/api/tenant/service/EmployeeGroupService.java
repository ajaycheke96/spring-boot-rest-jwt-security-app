package com.ajay.security.api.tenant.service;

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

	public String saveEmployeeGroup(EmployeeGroup employeeGroup) {
		return employeeGroupRepository.save(employeeGroup) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeGroup(EmployeeGroup employeeGroup) {
		return employeeGroupRepository.save(employeeGroup) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeGroup(Integer id) {
		employeeGroupRepository.deleteById(id);
		return " successfully deleted!";
	}
}
