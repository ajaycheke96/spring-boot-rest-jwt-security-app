package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.SyllabusDetail;
import com.ajay.security.api.tenant.repository.SyllabusDetailRepository;

@Service
@Transactional
public class SyllabusDetailService {

	@Autowired
	private SyllabusDetailRepository syllabusDetailRepository;

	public List<SyllabusDetail> getAllSyllabusDetails() {
		return syllabusDetailRepository.findAll();
	}

	public SyllabusDetail getOneSyllabusDetail(Integer id) {
		return syllabusDetailRepository.findById(id).get();
	}

	public String saveSyllabusDetail(SyllabusDetail syllabusDetail) {
		return syllabusDetailRepository.save(syllabusDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateSyllabusDetail(SyllabusDetail syllabusDetail) {
		return syllabusDetailRepository.save(syllabusDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneSyllabusDetail(Integer id) {
		syllabusDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
