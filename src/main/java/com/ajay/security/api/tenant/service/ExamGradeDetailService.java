package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamGradeDetail;
import com.ajay.security.api.tenant.repository.ExamGradeDetailRepository;

@Service
@Transactional
public class ExamGradeDetailService {

	@Autowired
	private ExamGradeDetailRepository examGradeDetailRepository;

	public List<ExamGradeDetail> getAllExamGradeDetails() {
		return examGradeDetailRepository.findAll();
	}

	public ExamGradeDetail getOneExamGradeDetail(Integer id) {
		return examGradeDetailRepository.findById(id).get();
	}

	public String saveExamGradeDetail(ExamGradeDetail examGradeDetail) {
		return examGradeDetailRepository.save(examGradeDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateExamGradeDetail(ExamGradeDetail examGradeDetail) {
		return examGradeDetailRepository.save(examGradeDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneExamGradeDetail(Integer id) {
		examGradeDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
