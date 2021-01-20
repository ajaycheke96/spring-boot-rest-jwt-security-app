package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamObservationDetail;
import com.ajay.security.api.tenant.repository.ExamObservationDetailRepository;

@Service
@Transactional
public class ExamObservationDetailService {

	@Autowired
	private ExamObservationDetailRepository examObservationDetailRepository;

	public List<ExamObservationDetail> getAllExamObservationDetails() {
		return examObservationDetailRepository.findAll();
	}

	public ExamObservationDetail getOneExamObservationDetail(Integer id) {
		return examObservationDetailRepository.findById(id).get();
	}

	public String saveExamObservationDetail(ExamObservationDetail examObservationDetail) {
		return examObservationDetailRepository.save(examObservationDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateExamObservationDetail(ExamObservationDetail examObservationDetail) {
		return examObservationDetailRepository.save(examObservationDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneExamObservationDetail(Integer id) {
		examObservationDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
