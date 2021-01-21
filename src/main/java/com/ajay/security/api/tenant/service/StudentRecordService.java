package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentRecord;
import com.ajay.security.api.tenant.repository.StudentRecordRepository;

@Service
@Transactional
public class StudentRecordService {

	@Autowired
	private StudentRecordRepository studentRecordRepository;

	public List<StudentRecord> getAllStudentRecords() {
		return studentRecordRepository.findAll();
	}

	public StudentRecord getOneStudentRecord(Integer id) {
		return studentRecordRepository.findById(id).get();
	}

	public String saveStudentRecord(StudentRecord studentRecord) {
		return studentRecordRepository.save(studentRecord) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentRecord(StudentRecord studentRecord) {
		return studentRecordRepository.save(studentRecord) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentRecord(Integer id) {
		studentRecordRepository.deleteById(id);
		return " successfully deleted!";
	}
}
