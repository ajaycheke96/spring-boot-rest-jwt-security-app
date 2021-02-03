package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Locale;
import com.ajay.security.api.tenant.repository.LocaleRepository;

@Service
@Transactional
public class LocaleService {

	@Autowired
	private LocaleRepository localeRepository;

	public List<Locale> getAllLocales() {
		return localeRepository.findAll();
	}

	public Locale getOneLocale(Integer id) {
		return localeRepository.findById(id).get();
	}

	public String saveLocale(Locale locale) {
		Timestamp currTimeStamp = new Timestamp(System.currentTimeMillis());
		locale.setCreatedAt(currTimeStamp);
		locale.setUpdatedAt(currTimeStamp);
		return localeRepository.save(locale) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateLocale(Locale locale) {
		Timestamp currTimeStamp = new Timestamp(System.currentTimeMillis());
		locale.setUpdatedAt(currTimeStamp);
		return localeRepository.save(locale) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneLocale(Integer id) {
		localeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
