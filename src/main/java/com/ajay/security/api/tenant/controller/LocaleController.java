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

import com.ajay.security.api.tenant.entity.Locale;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.LocaleService;

@RestController
@RequestMapping("/locale")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LocaleController {

	@Autowired
	private LocaleService localeService;

	@GetMapping("/listAllLocale")
	public ApiResponse getAllLocale() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Locale", localeService.getAllLocales());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Locale Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneLocale(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Locale", localeService.getOneLocale(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Locale Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveLocale")
	public ApiResponse saveLocale(@RequestBody Locale locale) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Locale saved!", localeService.saveLocale(locale));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Locale Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateLocale")
	public ApiResponse updateLocale(@RequestBody Locale locale) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Locale updated!", localeService.saveLocale(locale));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Locale Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteLocale")
	public ApiResponse deleteOneLocale(@RequestBody Locale locale) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, localeService.deleteOneLocale(locale), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Locale Service exception : " + e.getLocalizedMessage());
		}
	}
}
