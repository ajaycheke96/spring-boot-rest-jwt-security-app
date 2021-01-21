package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.SyllabusTopic;
import com.ajay.security.api.tenant.repository.SyllabusTopicRepository;

@Service
@Transactional
public class SyllabusTopicService {

	@Autowired
	private SyllabusTopicRepository syllabusTopicRepository;

	public List<SyllabusTopic> getAllSyllabusTopics() {
		return syllabusTopicRepository.findAll();
	}

	public SyllabusTopic getOneSyllabusTopic(Integer id) {
		return syllabusTopicRepository.findById(id).get();
	}

	public String saveSyllabusTopic(SyllabusTopic syllabusTopic) {
		return syllabusTopicRepository.save(syllabusTopic) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateSyllabusTopic(SyllabusTopic syllabusTopic) {
		return syllabusTopicRepository.save(syllabusTopic) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneSyllabusTopic(Integer id) {
		syllabusTopicRepository.deleteById(id);
		return " successfully deleted!";
	}
}
