package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamAssessment;
import com.ajay.security.api.tenant.repository.ExamAssessmentRepository;

@Service
@Transactional
public class ExamAssessmentService {

	@Autowired
	private ExamAssessmentRepository examAssessmentRepository;

	public List<ExamAssessment> getAllExamAssessments() {
		return examAssessmentRepository.findAll();
	}

	public ExamAssessment getOneExamAssessment(Integer id) {
		return examAssessmentRepository.findById(id).get();
	}

	public String saveExamAssessment(ExamAssessment examAssessment) {
		return examAssessmentRepository.save(examAssessment) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateExamAssessment(ExamAssessment examAssessment) {
		return examAssessmentRepository.save(examAssessment) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneExamAssessment(Integer id) {
		examAssessmentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
