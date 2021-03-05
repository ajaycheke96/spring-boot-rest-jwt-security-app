package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public ExamRecord saveExamRecord(ExamRecord examRecord) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (examRecord.getCreatedAt() == null)
			examRecord.setCreatedAt(currentTimestamp);
		examRecord.setUpdatedAt(currentTimestamp);
		return examRecordRepository.save(examRecord);
	}

	public String deleteOneExamRecord(ExamRecord examRecord) {
		String result = null;
		if (examRecordRepository.existsById(examRecord.getId())) {
			examRecordRepository.delete(examRecord);
			result = " ExamRecord deleted!";
		} else {
			result = "ExamRecord Not Found! or Already deleted!";
		}
		return result;
	}
}
