package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public EmployeeAttendance saveEmployeeAttendance(EmployeeAttendance employeeAttendance) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (employeeAttendance.getCreatedAt() == null)
			employeeAttendance.setCreatedAt(currentTimestamp);
		employeeAttendance.setUpdatedAt(currentTimestamp);

		// For employeeAttendanceDetails list
		if (!employeeAttendance.getEmployeeAttendanceDetails().isEmpty())
			employeeAttendance.getEmployeeAttendanceDetails().forEach(employeeAttendanceDetail -> {
				if (employeeAttendanceDetail.getCreatedAt() == null)
					employeeAttendanceDetail.setCreatedAt(currentTimestamp);
				employeeAttendanceDetail.setUpdatedAt(currentTimestamp);
			});
		return employeeAttendanceRepository.save(employeeAttendance);
	}

	public String deleteOneEmployeeAttendance(EmployeeAttendance employeeAttendance) {
		String result = null;
		if (employeeAttendanceRepository.existsById(employeeAttendance.getId())) {
			employeeAttendanceRepository.delete(employeeAttendance);
			result = " EmployeeAttendance deleted!";
		} else {
			result = "EmployeeAttendance Not Found! or Already deleted!";
		}
		return result;
	}
}
