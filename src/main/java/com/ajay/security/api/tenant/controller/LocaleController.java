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

import com.ajay.security.api.tenant.entity.Locale;
import com.ajay.security.api.tenant.service.LocaleService;

@RestController
@RequestMapping("/locale")
public class LocaleController {

	@Autowired
	private LocaleService localeService;

	@GetMapping("/all")
	public List<Locale> getAllLocale() {
		return localeService.getAllLocales();
	}

	@GetMapping("/one/{id}")
	public Locale getOneLocale(@PathVariable Integer id) {
		return localeService.getOneLocale(id);
	}

	@PostMapping("/save")
	public String saveLocale(@RequestBody Locale locale) {
		return localeService.saveLocale(locale);
	}

	@PutMapping("/update")
	public String updateLocale(@RequestBody Locale locale) {
		return localeService.updateLocale(locale);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneLocale(@PathVariable Integer id) {
		return localeService.deleteOneLocale(id);
	}
}
