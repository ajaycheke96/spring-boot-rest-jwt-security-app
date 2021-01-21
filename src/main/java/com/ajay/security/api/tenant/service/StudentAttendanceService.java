package com.ajay.security.api.tenant.service;

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

	public String saveStudentAttendance(StudentAttendance studentAttendance) {
		return studentAttendanceRepository.save(studentAttendance) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentAttendance(StudentAttendance studentAttendance) {
		return studentAttendanceRepository.save(studentAttendance) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentAttendance(Integer id) {
		studentAttendanceRepository.deleteById(id);
		return " successfully deleted!";
	}
}
