package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentOptionalFeeRecord;
import com.ajay.security.api.tenant.repository.StudentOptionalFeeRecordRepository;

@Service
@Transactional
public class StudentOptionalFeeRecordService {

	@Autowired
	private StudentOptionalFeeRecordRepository studentOptionalFeeRecordRepository;

	public List<StudentOptionalFeeRecord> getAllStudentOptionalFeeRecords() {
		return studentOptionalFeeRecordRepository.findAll();
	}

	public StudentOptionalFeeRecord getOneStudentOptionalFeeRecord(Integer id) {
		return studentOptionalFeeRecordRepository.findById(id).get();
	}

	public String saveStudentOptionalFeeRecord(StudentOptionalFeeRecord studentOptionalFeeRecord) {
		return studentOptionalFeeRecordRepository.save(studentOptionalFeeRecord) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentOptionalFeeRecord(StudentOptionalFeeRecord studentOptionalFeeRecord) {
		return studentOptionalFeeRecordRepository.save(studentOptionalFeeRecord) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentOptionalFeeRecord(Integer id) {
		studentOptionalFeeRecordRepository.deleteById(id);
		return " successfully deleted!";
	}
}
