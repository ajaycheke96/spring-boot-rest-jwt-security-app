package com.ajay.security.api.tenant.service;

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

	public String saveExam(Exam exam) {
		return examRepository.save(exam) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateExam(Exam exam) {
		return examRepository.save(exam) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneExam(Integer id) {
		examRepository.deleteById(id);
		return " successfully deleted!";
	}
}
