package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Subject saveSubject(Subject subject) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (subject.getCreatedAt() == null)
			subject.setCreatedAt(currentTimestamp);
		subject.setUpdatedAt(currentTimestamp);
		return subjectRepository.save(subject);
	}

	public String deleteOneSubject(Subject subject) {
		String result = null;
		if (subjectRepository.existsById(subject.getId())) {
			subjectRepository.delete(subject);
			result = " Subject deleted!";
		} else {
			result = "Subject Not Found! or Already deleted!";
		}
		return result;
	}
}
