package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Caste;
import com.ajay.security.api.tenant.repository.CasteRepository;

@Service
public class CasteService {

	@Autowired
	private CasteRepository casteRepository;

	public List<Caste> getAllCastes() {
		return casteRepository.findAll();
	}

	public Caste getOneCaste(Integer id) {
		return casteRepository.findById(id).get();
	}

	public String saveCaste(Caste caste) {
		return casteRepository.save(caste) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateCaste(Caste caste) {
		return casteRepository.save(caste) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneCaste(Integer id) {
		casteRepository.deleteById(id);
		return " successfully deleted!";
	}
}
