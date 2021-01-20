package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.EmployeeAttendance;
import com.ajay.security.api.tenant.repository.EmployeeAttendanceRepository;

@Service
public class EmployeeAttendanceService {

	@Autowired
	private EmployeeAttendanceRepository employeeAttendanceRepository;

	public List<EmployeeAttendance> getAllEmployeeAttendances() {
		return employeeAttendanceRepository.findAll();
	}

	public EmployeeAttendance getOneEmployeeAttendance(Integer id) {
		return employeeAttendanceRepository.findById(id).get();
	}

	public String saveEmployeeAttendance(EmployeeAttendance employeeAttendance) {
		return employeeAttendanceRepository.save(employeeAttendance) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateEmployeeAttendance(EmployeeAttendance employeeAttendance) {
		return employeeAttendanceRepository.save(employeeAttendance) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneEmployeeAttendance(Integer id) {
		employeeAttendanceRepository.deleteById(id);
		return " successfully deleted!";
	}
}
