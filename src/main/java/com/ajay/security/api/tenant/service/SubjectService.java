package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Subject;
import com.ajay.security.api.tenant.repository.SubjectRepository;

@Service
@Transactional
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;

	public List<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}

	public Subject getOneSubject(Integer id) {
		return subjectRepository.findById(id).get();
	}

	public String saveSubject(Subject subject) {
		return subjectRepository.save(subject) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateSubject(Subject subject) {
		return subjectRepository.save(subject) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneSubject(Integer id) {
		subjectRepository.deleteById(id);
		return " successfully deleted!";
	}
}
