package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Exam;
import com.ajay.security.api.tenant.repository.ExamRepository;

@Service
@Transactional
public class ExamService {

	@Autowired
	private ExamRepository examRepository;

	public List<Exam> getAllExams() {
		return examRepository.findAll();
	}

	public Exam getOneExam(Integer id) {
		return examRepository.findById(id).get();
	}

	public Exam saveExam(Exam exam) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (exam.getCreatedAt() == null)
			exam.setCreatedAt(currentTimestamp);
		exam.setUpdatedAt(currentTimestamp);
		return examRepository.save(exam);
	}

	public String deleteOneExam(Exam exam) {
		examRepository.delete(exam);
		return " successfully deleted!";
	}
}
