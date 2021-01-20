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

import com.ajay.security.api.tenant.entity.BookAuthor;
import com.ajay.security.api.tenant.service.BookAuthorService;

@RestController
@RequestMapping("/bookAuthor")
public class BookAuthorController {

	@Autowired
	private BookAuthorService bookAuthorService;

	@GetMapping("/all")
	public List<BookAuthor> getAllBookAuthor() {
		return bookAuthorService.getAllBookAuthors();
	}

	@GetMapping("/one/{id}")
	public BookAuthor getOneBookAuthor(@PathVariable Integer id) {
		return bookAuthorService.getOneBookAuthor(id);
	}

	@PostMapping("/save")
	public String saveBookAuthor(@RequestBody BookAuthor bookAuthor) {
		return bookAuthorService.saveBookAuthor(bookAuthor);
	}

	@PutMapping("/update")
	public String updateBookAuthor(@RequestBody BookAuthor bookAuthor) {
		return bookAuthorService.updateBookAuthor(bookAuthor);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBookAuthor(@PathVariable Integer id) {
		return bookAuthorService.deleteOneBookAuthor(id);
	}
}
