package com.ajay.security.api.tenant.service;

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

	public String saveRegistration(Registration registration) {
		return registrationRepository.save(registration) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateRegistration(Registration registration) {
		return registrationRepository.save(registration) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneRegistration(Integer id) {
		registrationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
