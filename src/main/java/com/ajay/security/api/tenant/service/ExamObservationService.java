package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public ExamObservation saveExamObservation(ExamObservation examObservation) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (examObservation.getCreatedAt() == null)
			examObservation.setCreatedAt(currentTimestamp);
		examObservation.setUpdatedAt(currentTimestamp);

		// For examObservationDetails list
		if (!examObservation.getExamObservationDetails().isEmpty())
			examObservation.getExamObservationDetails().forEach(examObservationDetail -> {
				if (examObservationDetail.getCreatedAt() == null)
					examObservationDetail.setCreatedAt(currentTimestamp);
				examObservationDetail.setUpdatedAt(currentTimestamp);
			});
		return examObservationRepository.save(examObservation);
	}

	public String deleteOneExamObservation(ExamObservation examObservation) {
		String result = null;
		if (examObservationRepository.existsById(examObservation.getId())) {
			examObservationRepository.delete(examObservation);
			result = " ExamObservation deleted!";
		} else {
			result = "ExamObservation Not Found! or Already deleted!";
		}
		return result;
	}
}
