package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamRecord;
import com.ajay.security.api.tenant.repository.ExamRecordRepository;

@Service
@Transactional
public class ExamRecordService {

	@Autowired
	private ExamRecordRepository examRecordRepository;

	public List<ExamRecord> getAllExamRecords() {
		return examRecordRepository.findAll();
	}

	public ExamRecord getOneExamRecord(Integer id) {
		return examRecordRepository.findById(id).get();
	}

	public String saveExamRecord(ExamRecord examRecord) {
		return examRecordRepository.save(examRecord) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateExamRecord(ExamRecord examRecord) {
		return examRecordRepository.save(examRecord) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneExamRecord(Integer id) {
		examRecordRepository.deleteById(id);
		return " successfully deleted!";
	}
}
