package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeLeaveAllocation;
import com.ajay.security.api.tenant.repository.EmployeeLeaveAllocationRepository;

@Service
@Transactional
public class EmployeeLeaveAllocationService {

	@Autowired
	private EmployeeLeaveAllocationRepository employeeLeaveAllocationRepository;

	public List<EmployeeLeaveAllocation> getAllEmployeeLeaveAllocations() {
		return employeeLeaveAllocationRepository.findAll();
	}

	public EmployeeLeaveAllocation getOneEmployeeLeaveAllocation(Integer id) {
		return employeeLeaveAllocationRepository.findById(id).get();
	}

	public String saveEmployeeLeaveAllocation(EmployeeLeaveAllocation employeeLeaveAllocation) {
		return employeeLeaveAllocationRepository.save(employeeLeaveAllocation) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeLeaveAllocation(EmployeeLeaveAllocation employeeLeaveAllocation) {
		return employeeLeaveAllocationRepository.save(employeeLeaveAllocation) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeLeaveAllocation(Integer id) {
		employeeLeaveAllocationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
