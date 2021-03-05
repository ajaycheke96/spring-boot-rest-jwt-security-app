package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Religion saveReligion(Religion religion) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (religion.getCreatedAt() == null)
			religion.setCreatedAt(currentTimestamp);
		religion.setUpdatedAt(currentTimestamp);
		return religionRepository.save(religion);
	}

	public String deleteOneReligion(Religion religion) {
		String result = null;
		if (religionRepository.existsById(religion.getId())) {
			religionRepository.delete(religion);
			result = " Religion deleted!";
		} else {
			result = "Religion Not Found! or Already deleted!";
		}
		return result;
	}
}
