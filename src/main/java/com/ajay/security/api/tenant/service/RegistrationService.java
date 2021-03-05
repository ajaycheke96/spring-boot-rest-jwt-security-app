package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Registration;
import com.ajay.security.api.tenant.repository.RegistrationRepository;

@Service
@Transactional
public class RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	public List<Registration> getAllRegistrations() {
		return registrationRepository.findAll();
	}

	public Registration getOneRegistration(Integer id) {
		return registrationRepository.findById(id).get();
	}

	public Registration saveRegistration(Registration registration) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (registration.getCreatedAt() == null)
			registration.setCreatedAt(currentTimestamp);
		registration.setUpdatedAt(currentTimestamp);
		return registrationRepository.save(registration);
	}

	public String deleteOneRegistration(Registration registration) {
		String result = null;
		if (registrationRepository.existsById(registration.getId())) {
			registrationRepository.delete(registration);
			result = "Registration deleted!";
		} else {
			result = "Registration not found! Or Already deleted!";
		}
		return result;
	}
}
