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

import com.ajay.security.api.tenant.entity.BookPublisher;
import com.ajay.security.api.tenant.service.BookPublisherService;

@RestController
@RequestMapping("/bookPublisher")
public class BookPublisherController {

	@Autowired
	private BookPublisherService bookPublisherService;

	@GetMapping("/all")
	public List<BookPublisher> getAllBookPublisher() {
		return bookPublisherService.getAllBookPublishers();
	}

	@GetMapping("/one/{id}")
	public BookPublisher getOneBookPublisher(@PathVariable Integer id) {
		return bookPublisherService.getOneBookPublisher(id);
	}

	@PostMapping("/save")
	public String saveBookPublisher(@RequestBody BookPublisher bookPublisher) {
		return bookPublisherService.saveBookPublisher(bookPublisher);
	}

	@PutMapping("/update")
	public String updateBookPublisher(@RequestBody BookPublisher bookPublisher) {
		return bookPublisherService.updateBookPublisher(bookPublisher);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBookPublisher(@PathVariable Integer id) {
		return bookPublisherService.deleteOneBookPublisher(id);
	}
}
