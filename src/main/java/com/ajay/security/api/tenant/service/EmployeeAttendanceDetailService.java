package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.EmployeeAttendanceDetail;
import com.ajay.security.api.tenant.repository.EmployeeAttendanceDetailRepository;

@Service
public class EmployeeAttendanceDetailService {

	@Autowired
	private EmployeeAttendanceDetailRepository employeeAttendanceDetailRepository;

	public List<EmployeeAttendanceDetail> getAllEmployeeAttendanceDetails() {
		return employeeAttendanceDetailRepository.findAll();
	}

	public EmployeeAttendanceDetail getOneEmployeeAttendanceDetail(Integer id) {
		return employeeAttendanceDetailRepository.findById(id).get();
	}

	public String saveEmployeeAttendanceDetail(EmployeeAttendanceDetail employeeAttendanceDetail) {
		return employeeAttendanceDetailRepository.save(employeeAttendanceDetail) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateEmployeeAttendanceDetail(EmployeeAttendanceDetail employeeAttendanceDetail) {
		return employeeAttendanceDetailRepository.save(employeeAttendanceDetail) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneEmployeeAttendanceDetail(Integer id) {
		employeeAttendanceDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
