package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public EmployeeLeaveType saveEmployeeLeaveType(EmployeeLeaveType employeeLeaveType) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employeeLeaveType.getCreatedAt() == null)
			employeeLeaveType.setCreatedAt(currentTimestamp);
		employeeLeaveType.setUpdatedAt(currentTimestamp);
		return employeeLeaveTypeRepository.save(employeeLeaveType);
	}

	public String deleteOneEmployeeLeaveType(EmployeeLeaveType employeeLeaveType) {
		String result = null;
		if (employeeLeaveTypeRepository.existsById(employeeLeaveType.getId())) {
			employeeLeaveTypeRepository.delete(employeeLeaveType);
			result = " EmployeeLeaveType deleted!";
		} else {
			result = "EmployeeLeaveType Not Found! or Already deleted!";
		}
		return result;
	}
}
