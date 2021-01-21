package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Syllabus;
import com.ajay.security.api.tenant.repository.SyllabusRepository;

@Service
@Transactional
public class SyllabusService {

	@Autowired
	private SyllabusRepository syllabusRepository;

	public List<Syllabus> getAllSyllabuss() {
		return syllabusRepository.findAll();
	}

	public Syllabus getOneSyllabus(Integer id) {
		return syllabusRepository.findById(id).get();
	}

	public String saveSyllabus(Syllabus syllabus) {
		return syllabusRepository.save(syllabus) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateSyllabus(Syllabus syllabus) {
		return syllabusRepository.save(syllabus) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneSyllabus(Integer id) {
		syllabusRepository.deleteById(id);
		return " successfully deleted!";
	}
}
