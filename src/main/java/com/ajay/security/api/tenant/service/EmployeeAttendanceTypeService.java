package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public EmployeeAttendanceType saveEmployeeAttendanceType(EmployeeAttendanceType employeeAttendanceType) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employeeAttendanceType.getCreatedAt() == null)
			employeeAttendanceType.setCreatedAt(currentTimestamp);
		employeeAttendanceType.setUpdatedAt(currentTimestamp);
		return employeeAttendanceTypeRepository.save(employeeAttendanceType);
	}

	public String deleteOneEmployeeAttendanceType(EmployeeAttendanceType employeeAttendanceType) {
		String result = null;
		if (employeeAttendanceTypeRepository.existsById(employeeAttendanceType.getId())) {
			employeeAttendanceTypeRepository.delete(employeeAttendanceType);
			result = " EmployeeAttendanceType deleted!";
		} else {
			result = "EmployeeAttendanceType Not Found! or Already deleted!";
		}
		return result;
	}
}
