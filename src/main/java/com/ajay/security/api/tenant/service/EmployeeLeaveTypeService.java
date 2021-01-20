package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.EmployeeLeaveType;
import com.ajay.security.api.tenant.repository.EmployeeLeaveTypeRepository;

@Service
@Transactional
public class EmployeeLeaveTypeService {

	@Autowired
	private EmployeeLeaveTypeRepository employeeLeaveTypeRepository;

	public List<EmployeeLeaveType> getAllEmployeeLeaveTypes() {
		return employeeLeaveTypeRepository.findAll();
	}

	public EmployeeLeaveType getOneEmployeeLeaveType(Integer id) {
		return employeeLeaveTypeRepository.findById(id).get();
	}

	public String saveEmployeeLeaveType(EmployeeLeaveType employeeLeaveType) {
		return employeeLeaveTypeRepository.save(employeeLeaveType) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeLeaveType(EmployeeLeaveType employeeLeaveType) {
		return employeeLeaveTypeRepository.save(employeeLeaveType) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeLeaveType(Integer id) {
		employeeLeaveTypeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
