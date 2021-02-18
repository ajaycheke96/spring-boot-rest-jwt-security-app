package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.ExamTerm;
import com.ajay.security.api.tenant.repository.ExamTermRepository;

@Service
@Transactional
public class ExamTermService {

	@Autowired
	private ExamTermRepository examTermRepository;

	public List<ExamTerm> getAllExamTerms() {
		return examTermRepository.findAll();
	}

	public ExamTerm getOneExamTerm(Integer id) {
		return examTermRepository.findById(id).get();
	}

	public ExamTerm saveExamTerm(ExamTerm examTerm) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (examTerm.getCreatedAt() == null)
			examTerm.setCreatedAt(currentTimestamp);
		examTerm.setUpdatedAt(currentTimestamp);
		return examTermRepository.save(examTerm);
	}

	public String deleteOneExamTerm(ExamTerm examTerm) {
		examTermRepository.delete(examTerm);
		return " successfully deleted!";
	}
}
