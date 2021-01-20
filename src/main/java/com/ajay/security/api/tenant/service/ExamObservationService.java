package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamObservation;
import com.ajay.security.api.tenant.repository.ExamObservationRepository;

@Service
@Transactional
public class ExamObservationService {

	@Autowired
	private ExamObservationRepository examObservationRepository;

	public List<ExamObservation> getAllExamObservations() {
		return examObservationRepository.findAll();
	}

	public ExamObservation getOneExamObservation(Integer id) {
		return examObservationRepository.findById(id).get();
	}

	public String saveExamObservation(ExamObservation examObservation) {
		return examObservationRepository.save(examObservation) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateExamObservation(ExamObservation examObservation) {
		return examObservationRepository.save(examObservation) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneExamObservation(Integer id) {
		examObservationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
