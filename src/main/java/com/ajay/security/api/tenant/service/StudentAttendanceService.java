package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentAttendance;
import com.ajay.security.api.tenant.repository.StudentAttendanceRepository;

@Service
@Transactional
public class StudentAttendanceService {

	@Autowired
	private StudentAttendanceRepository studentAttendanceRepository;

	public List<StudentAttendance> getAllStudentAttendances() {
		return studentAttendanceRepository.findAll();
	}

	public StudentAttendance getOneStudentAttendance(Integer id) {
		return studentAttendanceRepository.findById(id).get();
	}

	public StudentAttendance saveStudentAttendance(StudentAttendance studentAttendance) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (studentAttendance.getCreatedAt() == null)
			studentAttendance.setCreatedAt(currentTimestamp);
		studentAttendance.setUpdatedAt(currentTimestamp);
		return studentAttendanceRepository.save(studentAttendance);
	}

	public String deleteOneStudentAttendance(StudentAttendance studentAttendance) {
		String result = null;
		if (studentAttendanceRepository.existsById(studentAttendance.getId())) {
			studentAttendanceRepository.delete(studentAttendance);
			result = " StudentAttendance deleted!";
		} else {
			result = "StudentAttendance Not Found! or Already deleted!";
		}
		return result;
	}
}
