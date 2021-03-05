package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public EmployeeLeaveAllocation saveEmployeeLeaveAllocation(EmployeeLeaveAllocation employeeLeaveAllocation) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employeeLeaveAllocation.getCreatedAt() == null)
			employeeLeaveAllocation.setCreatedAt(currentTimestamp);
		employeeLeaveAllocation.setUpdatedAt(currentTimestamp);

		// For employeeLeaveAllocationDetails list
		if (!employeeLeaveAllocation.getEmployeeLeaveAllocationDetails().isEmpty())
			employeeLeaveAllocation.getEmployeeLeaveAllocationDetails().forEach(employeeLeaveAllocationDetail -> {
				if (employeeLeaveAllocationDetail.getCreatedAt() == null)
					employeeLeaveAllocationDetail.setCreatedAt(currentTimestamp);
				employeeLeaveAllocationDetail.setUpdatedAt(currentTimestamp);
			});
		return employeeLeaveAllocationRepository.save(employeeLeaveAllocation);
	}

	public String deleteOneEmployeeLeaveAllocation(EmployeeLeaveAllocation employeeLeaveAllocation) {
		String result = null;
		if (employeeLeaveAllocationRepository.existsById(employeeLeaveAllocation.getId())) {
			employeeLeaveAllocationRepository.delete(employeeLeaveAllocation);
			result = " EmployeeLeaveAllocation deleted!";
		} else {
			result = "EmployeeLeaveAllocation Not Found! or Already deleted!";
		}
		return result;
	}
}
