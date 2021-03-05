package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Syllabus saveSyllabus(Syllabus syllabus) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (syllabus.getCreatedAt() == null)
			syllabus.setCreatedAt(currentTimestamp);
		syllabus.setUpdatedAt(currentTimestamp);

		// For SyllabusDetails list
		if (!syllabus.getSyllabusDetails().isEmpty())
			syllabus.getSyllabusDetails().forEach(syllabusDetail -> {
				if (syllabusDetail.getCreatedAt() == null)
					syllabusDetail.setCreatedAt(currentTimestamp);
				syllabusDetail.setUpdatedAt(currentTimestamp);
			});

		// For SyllabusTopics list
		if (!syllabus.getSyllabusTopics().isEmpty())
			syllabus.getSyllabusTopics().forEach(syllabusTopic -> {
				if (syllabusTopic.getCreatedAt() == null)
					syllabusTopic.setCreatedAt(currentTimestamp);
				syllabusTopic.setUpdatedAt(currentTimestamp);
			});

		return syllabusRepository.save(syllabus);
	}

	public String deleteOneSyllabus(Syllabus syllabus) {
		String result = null;
		if (syllabusRepository.existsById(syllabus.getId())) {
			syllabusRepository.delete(syllabus);
			result = " Syllabus deleted!";
		} else {
			result = "Syllabus Not Found! or Already deleted!";
		}
		return result;
	}
}
