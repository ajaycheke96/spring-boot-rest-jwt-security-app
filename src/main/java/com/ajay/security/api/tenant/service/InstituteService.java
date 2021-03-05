package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Institute saveInstitute(Institute institute) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (institute.getCreatedAt() == null)
			institute.setCreatedAt(currentTimestamp);
		institute.setUpdatedAt(currentTimestamp);
		return instituteRepository.save(institute);
	}

	public String deleteOneInstitute(Institute institute) {
		String result = null;
		if (instituteRepository.existsById(institute.getId())) {
			instituteRepository.delete(institute);
			result = " Institute deleted!";
		} else {
			result = "Institute Not Found! or Already deleted!";
		}
		return result;
	}
}
