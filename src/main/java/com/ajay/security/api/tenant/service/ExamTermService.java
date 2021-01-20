package com.ajay.security.api.tenant.service;

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

	public String saveExamTerm(ExamTerm examTerm) {
		return examTermRepository.save(examTerm) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateExamTerm(ExamTerm examTerm) {
		return examTermRepository.save(examTerm) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneExamTerm(Integer id) {
		examTermRepository.deleteById(id);
		return " successfully deleted!";
	}
}
