package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamAssessmentDetail;
import com.ajay.security.api.tenant.repository.ExamAssessmentDetailRepository;

@Service
@Transactional
public class ExamAssessmentDetailService {

	@Autowired
	private ExamAssessmentDetailRepository examAssessmentDetailRepository;

	public List<ExamAssessmentDetail> getAllExamAssessmentDetails() {
		return examAssessmentDetailRepository.findAll();
	}

	public ExamAssessmentDetail getOneExamAssessmentDetail(Integer id) {
		return examAssessmentDetailRepository.findById(id).get();
	}

	public String saveExamAssessmentDetail(ExamAssessmentDetail examAssessmentDetail) {
		return examAssessmentDetailRepository.save(examAssessmentDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateExamAssessmentDetail(ExamAssessmentDetail examAssessmentDetail) {
		return examAssessmentDetailRepository.save(examAssessmentDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneExamAssessmentDetail(Integer id) {
		examAssessmentDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
