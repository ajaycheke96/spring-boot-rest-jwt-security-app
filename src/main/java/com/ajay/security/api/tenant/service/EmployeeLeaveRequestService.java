package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeLeaveRequest;
import com.ajay.security.api.tenant.repository.EmployeeLeaveRequestRepository;

@Service
@Transactional
public class EmployeeLeaveRequestService {

	@Autowired
	private EmployeeLeaveRequestRepository employeeLeaveRequestRepository;

	public List<EmployeeLeaveRequest> getAllEmployeeLeaveRequests() {
		return employeeLeaveRequestRepository.findAll();
	}

	public EmployeeLeaveRequest getOneEmployeeLeaveRequest(Integer id) {
		return employeeLeaveRequestRepository.findById(id).get();
	}

	public String saveEmployeeLeaveRequest(EmployeeLeaveRequest employeeLeaveRequest) {
		return employeeLeaveRequestRepository.save(employeeLeaveRequest) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeLeaveRequest(EmployeeLeaveRequest employeeLeaveRequest) {
		return employeeLeaveRequestRepository.save(employeeLeaveRequest) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeLeaveRequest(Integer id) {
		employeeLeaveRequestRepository.deleteById(id);
		return " successfully deleted!";
	}
}
