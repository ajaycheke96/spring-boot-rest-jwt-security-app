package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.Registration;
import com.ajay.security.api.tenant.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/all")
	public List<Registration> getAllRegistration() {
		return registrationService.getAllRegistrations();
	}

	@GetMapping("/one/{id}")
	public Registration getOneRegistration(@PathVariable Integer id) {
		return registrationService.getOneRegistration(id);
	}

	@PostMapping("/save")
	public String saveRegistration(@RequestBody Registration registration) {
		return registrationService.saveRegistration(registration);
	}

	@PutMapping("/update")
	public String updateRegistration(@RequestBody Registration registration) {
		return registrationService.updateRegistration(registration);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneRegistration(@PathVariable Integer id) {
		return registrationService.deleteOneRegistration(id);
	}
}
