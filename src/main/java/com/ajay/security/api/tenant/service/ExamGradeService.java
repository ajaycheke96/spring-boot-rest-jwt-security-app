package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamGrade;
import com.ajay.security.api.tenant.repository.ExamGradeRepository;

@Service
@Transactional
public class ExamGradeService {

	@Autowired
	private ExamGradeRepository examGradeRepository;

	public List<ExamGrade> getAllExamGrades() {
		return examGradeRepository.findAll();
	}

	public ExamGrade getOneExamGrade(Integer id) {
		return examGradeRepository.findById(id).get();
	}

	public String saveExamGrade(ExamGrade examGrade) {
		return examGradeRepository.save(examGrade) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateExamGrade(ExamGrade examGrade) {
		return examGradeRepository.save(examGrade) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneExamGrade(Integer id) {
		examGradeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
