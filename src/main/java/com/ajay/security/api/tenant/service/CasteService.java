package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Caste saveCaste(Caste caste) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (caste.getCreatedAt() == null)
			caste.setCreatedAt(currentTimestamp);
		caste.setUpdatedAt(currentTimestamp);
		return casteRepository.save(caste);
	}

	public String deleteOneCaste(Caste caste) {
		String result = null;
		if (casteRepository.existsById(caste.getId())) {
			casteRepository.delete(caste);
			result = " Caste deleted!";
		} else {
			result = "Caste Not Found! or Already deleted!";
		}
		return result;
	}
}
