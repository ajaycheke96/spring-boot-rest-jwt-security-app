package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Registration;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.RegistrationService;

@RestController
@RequestMapping("/registration")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@GetMapping("/listAllRegistration")
	public ApiResponse getAllRegistration() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Registration",
					registrationService.getAllRegistrations());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Registration Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneRegistration(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Registration",
					registrationService.getOneRegistration(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Registration Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveRegistration")
	public ApiResponse saveRegistration(@RequestBody Registration registration) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Registration saved!",
					registrationService.saveRegistration(registration));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Registration Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateRegistration")
	public ApiResponse updateRegistration(@RequestBody Registration registration) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Registration updated!",
					registrationService.saveRegistration(registration));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Registration Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteRegistration")
	public ApiResponse deleteOneRegistration(@RequestBody Registration registration) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					registrationService.deleteOneRegistration(registration), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Registration Service exception : " + e.getLocalizedMessage());
		}
	}
}
