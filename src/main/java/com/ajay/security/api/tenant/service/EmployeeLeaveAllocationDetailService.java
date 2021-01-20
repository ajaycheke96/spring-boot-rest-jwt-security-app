package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeLeaveAllocationDetail;
import com.ajay.security.api.tenant.repository.EmployeeLeaveAllocationDetailRepository;

@Service
@Transactional
public class EmployeeLeaveAllocationDetailService {

	@Autowired
	private EmployeeLeaveAllocationDetailRepository employeeLeaveAllocationDetailRepository;

	public List<EmployeeLeaveAllocationDetail> getAllEmployeeLeaveAllocationDetails() {
		return employeeLeaveAllocationDetailRepository.findAll();
	}

	public EmployeeLeaveAllocationDetail getOneEmployeeLeaveAllocationDetail(Integer id) {
		return employeeLeaveAllocationDetailRepository.findById(id).get();
	}

	public String saveEmployeeLeaveAllocationDetail(EmployeeLeaveAllocationDetail employeeLeaveAllocationDetail) {
		return employeeLeaveAllocationDetailRepository.save(employeeLeaveAllocationDetail) != null
				? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeLeaveAllocationDetail(EmployeeLeaveAllocationDetail employeeLeaveAllocationDetail) {
		return employeeLeaveAllocationDetailRepository.save(employeeLeaveAllocationDetail) != null
				? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeLeaveAllocationDetail(Integer id) {
		employeeLeaveAllocationDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
