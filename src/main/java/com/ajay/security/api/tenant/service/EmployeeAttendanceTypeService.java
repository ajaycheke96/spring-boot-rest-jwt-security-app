package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.EmployeeAttendanceType;
import com.ajay.security.api.tenant.repository.EmployeeAttendanceTypeRepository;

@Service
public class EmployeeAttendanceTypeService {

	@Autowired
	private EmployeeAttendanceTypeRepository employeeAttendanceTypeRepository;

	public List<EmployeeAttendanceType> getAllEmployeeAttendanceTypes() {
		return employeeAttendanceTypeRepository.findAll();
	}

	public EmployeeAttendanceType getOneEmployeeAttendanceType(Integer id) {
		return employeeAttendanceTypeRepository.findById(id).get();
	}

	public String saveEmployeeAttendanceType(EmployeeAttendanceType employeeAttendanceType) {
		return employeeAttendanceTypeRepository.save(employeeAttendanceType) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeAttendanceType(EmployeeAttendanceType employeeAttendanceType) {
		return employeeAttendanceTypeRepository.save(employeeAttendanceType) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeAttendanceType(Integer id) {
		employeeAttendanceTypeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
