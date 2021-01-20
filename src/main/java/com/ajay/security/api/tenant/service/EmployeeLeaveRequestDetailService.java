package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeLeaveRequestDetail;
import com.ajay.security.api.tenant.repository.EmployeeLeaveRequestDetailRepository;

@Service
@Transactional
public class EmployeeLeaveRequestDetailService {

	@Autowired
	private EmployeeLeaveRequestDetailRepository employeeLeaveRequestDetailRepository;

	public List<EmployeeLeaveRequestDetail> getAllEmployeeLeaveRequestDetails() {
		return employeeLeaveRequestDetailRepository.findAll();
	}

	public EmployeeLeaveRequestDetail getOneEmployeeLeaveRequestDetail(Integer id) {
		return employeeLeaveRequestDetailRepository.findById(id).get();
	}

	public String saveEmployeeLeaveRequestDetail(EmployeeLeaveRequestDetail employeeLeaveRequestDetail) {
		return employeeLeaveRequestDetailRepository.save(employeeLeaveRequestDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeLeaveRequestDetail(EmployeeLeaveRequestDetail employeeLeaveRequestDetail) {
		return employeeLeaveRequestDetailRepository.save(employeeLeaveRequestDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeLeaveRequestDetail(Integer id) {
		employeeLeaveRequestDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
