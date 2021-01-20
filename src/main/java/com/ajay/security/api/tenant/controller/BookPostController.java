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

import com.ajay.security.api.tenant.entity.BookPost;
import com.ajay.security.api.tenant.service.BookPostService;

@RestController
@RequestMapping("/bookPost")
public class BookPostController {

	@Autowired
	private BookPostService bookPostService;

	@GetMapping("/all")
	public List<BookPost> getAllBookPost() {
		return bookPostService.getAllBookPosts();
	}

	@GetMapping("/one/{id}")
	public BookPost getOneBookPost(@PathVariable Integer id) {
		return bookPostService.getOneBookPost(id);
	}

	@PostMapping("/save")
	public String saveBookPost(@RequestBody BookPost bookPost) {
		return bookPostService.saveBookPost(bookPost);
	}

	@PutMapping("/update")
	public String updateBookPost(@RequestBody BookPost bookPost) {
		return bookPostService.updateBookPost(bookPost);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBookPost(@PathVariable Integer id) {
		return bookPostService.deleteOneBookPost(id);
	}
}
