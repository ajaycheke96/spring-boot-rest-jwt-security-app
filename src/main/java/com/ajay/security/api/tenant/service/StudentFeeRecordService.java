package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentFeeRecord;
import com.ajay.security.api.tenant.repository.StudentFeeRecordRepository;

@Service
@Transactional
public class StudentFeeRecordService {

	@Autowired
	private StudentFeeRecordRepository studentFeeRecordRepository;

	public List<StudentFeeRecord> getAllStudentFeeRecords() {
		return studentFeeRecordRepository.findAll();
	}

	public StudentFeeRecord getOneStudentFeeRecord(Integer id) {
		return studentFeeRecordRepository.findById(id).get();
	}

	public String saveStudentFeeRecord(StudentFeeRecord studentFeeRecord) {
		return studentFeeRecordRepository.save(studentFeeRecord) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentFeeRecord(StudentFeeRecord studentFeeRecord) {
		return studentFeeRecordRepository.save(studentFeeRecord) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentFeeRecord(Integer id) {
		studentFeeRecordRepository.deleteById(id);
		return " successfully deleted!";
	}
}
