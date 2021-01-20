package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BookLanguage;
import com.ajay.security.api.tenant.repository.BookLanguageRepository;

@Service
public class BookLanguageService {

	@Autowired
	private BookLanguageRepository bookLanguageRepository;

	public List<BookLanguage> getAllBookLanguages() {
		return bookLanguageRepository.findAll();
	}

	public BookLanguage getOneBookLanguage(Integer id) {
		return bookLanguageRepository.findById(id).get();
	}

	public String saveBookLanguage(BookLanguage bookLanguage) {
		return bookLanguageRepository.save(bookLanguage) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateBookLanguage(BookLanguage bookLanguage) {
		return bookLanguageRepository.save(bookLanguage) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneBookLanguage(Integer id) {
		bookLanguageRepository.deleteById(id);
		return " successfully deleted!";
	}
}
