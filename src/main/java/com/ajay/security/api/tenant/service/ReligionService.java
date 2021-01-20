package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Religion;
import com.ajay.security.api.tenant.repository.ReligionRepository;

@Service
@Transactional
public class ReligionService {

	@Autowired
	private ReligionRepository religionRepository;

	public List<Religion> getAllReligions() {
		return religionRepository.findAll();
	}

	public Religion getOneReligion(Integer id) {
		return religionRepository.findById(id).get();
	}

	public String saveReligion(Religion religion) {
		return religionRepository.save(religion) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateReligion(Religion religion) {
		return religionRepository.save(religion) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneReligion(Integer id) {
		religionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
