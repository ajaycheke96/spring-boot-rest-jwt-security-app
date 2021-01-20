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

import com.ajay.security.api.tenant.entity.BookTopic;
import com.ajay.security.api.tenant.service.BookTopicService;

@RestController
@RequestMapping("/bookTopic")
public class BookTopicController {

	@Autowired
	private BookTopicService bookTopicService;

	@GetMapping("/all")
	public List<BookTopic> getAllBookTopic() {
		return bookTopicService.getAllBookTopics();
	}

	@GetMapping("/one/{id}")
	public BookTopic getOneBookTopic(@PathVariable Integer id) {
		return bookTopicService.getOneBookTopic(id);
	}

	@PostMapping("/save")
	public String saveBookTopic(@RequestBody BookTopic bookTopic) {
		return bookTopicService.saveBookTopic(bookTopic);
	}

	@PutMapping("/update")
	public String updateBookTopic(@RequestBody BookTopic bookTopic) {
		return bookTopicService.updateBookTopic(bookTopic);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBookTopic(@PathVariable Integer id) {
		return bookTopicService.deleteOneBookTopic(id);
	}
}
