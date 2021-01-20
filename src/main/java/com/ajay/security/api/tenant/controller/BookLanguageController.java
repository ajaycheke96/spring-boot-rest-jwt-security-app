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

import com.ajay.security.api.tenant.entity.BookLanguage;
import com.ajay.security.api.tenant.service.BookLanguageService;

@RestController
@RequestMapping("/bookLanguage")
public class BookLanguageController {

	@Autowired
	private BookLanguageService bookLanguageService;

	@GetMapping("/all")
	public List<BookLanguage> getAllBookLanguage() {
		return bookLanguageService.getAllBookLanguages();
	}

	@GetMapping("/one/{id}")
	public BookLanguage getOneBookLanguage(@PathVariable Integer id) {
		return bookLanguageService.getOneBookLanguage(id);
	}

	@PostMapping("/save")
	public String saveBookLanguage(@RequestBody BookLanguage bookLanguage) {
		return bookLanguageService.saveBookLanguage(bookLanguage);
	}

	@PutMapping("/update")
	public String updateBookLanguage(@RequestBody BookLanguage bookLanguage) {
		return bookLanguageService.updateBookLanguage(bookLanguage);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBookLanguage(@PathVariable Integer id) {
		return bookLanguageService.deleteOneBookLanguage(id);
	}
}
