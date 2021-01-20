package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Institute;
import com.ajay.security.api.tenant.repository.InstituteRepository;

@Service
@Transactional
public class InstituteService {

	@Autowired
	private InstituteRepository instituteRepository;

	public List<Institute> getAllInstitutes() {
		return instituteRepository.findAll();
	}

	public Institute getOneInstitute(Integer id) {
		return instituteRepository.findById(id).get();
	}

	public String saveInstitute(Institute institute) {
		return instituteRepository.save(institute) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateInstitute(Institute institute) {
		return instituteRepository.save(institute) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneInstitute(Integer id) {
		instituteRepository.deleteById(id);
		return " successfully deleted!";
	}
}
