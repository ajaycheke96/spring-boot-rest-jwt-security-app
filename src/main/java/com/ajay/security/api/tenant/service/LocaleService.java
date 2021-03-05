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

	public Locale saveLocale(Locale locale) {
		Timestamp currTimeStamp = new Timestamp(System.currentTimeMillis());
		if (locale.getCreatedAt() == null)
			locale.setCreatedAt(currTimeStamp);
		locale.setUpdatedAt(currTimeStamp);
		return localeRepository.save(locale);
	}

	public String deleteOneLocale(Locale locale) {
		String result = null;
		if (localeRepository.existsById(locale.getId())) {
			localeRepository.delete(locale);
			result = " Locale deleted!";
		} else {
			result = "Locale Not Found! or Already deleted!";
		}
		return result;
	}
}
