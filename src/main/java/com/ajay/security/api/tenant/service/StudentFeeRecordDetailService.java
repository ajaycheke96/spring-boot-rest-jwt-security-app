package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StudentFeeRecordDetail;
import com.ajay.security.api.tenant.repository.StudentFeeRecordDetailRepository;

@Service
@Transactional
public class StudentFeeRecordDetailService {

	@Autowired
	private StudentFeeRecordDetailRepository studentFeeRecordDetailRepository;

	public List<StudentFeeRecordDetail> getAllStudentFeeRecordDetails() {
		return studentFeeRecordDetailRepository.findAll();
	}

	public StudentFeeRecordDetail getOneStudentFeeRecordDetail(Integer id) {
		return studentFeeRecordDetailRepository.findById(id).get();
	}

	public String saveStudentFeeRecordDetail(StudentFeeRecordDetail studentFeeRecordDetail) {
		return studentFeeRecordDetailRepository.save(studentFeeRecordDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStudentFeeRecordDetail(StudentFeeRecordDetail studentFeeRecordDetail) {
		return studentFeeRecordDetailRepository.save(studentFeeRecordDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStudentFeeRecordDetail(Integer id) {
		studentFeeRecordDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
