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

import com.ajay.security.api.tenant.entity.BookPostDetail;
import com.ajay.security.api.tenant.service.BookPostDetailService;

@RestController
@RequestMapping("/bookPostDetail")
public class BookPostDetailController {

	@Autowired
	private BookPostDetailService bookPostDetailService;

	@GetMapping("/all")
	public List<BookPostDetail> getAllBookPostDetail() {
		return bookPostDetailService.getAllBookPostDetails();
	}

	@GetMapping("/one/{id}")
	public BookPostDetail getOneBookPostDetail(@PathVariable Integer id) {
		return bookPostDetailService.getOneBookPostDetail(id);
	}

	@PostMapping("/save")
	public String saveBookPostDetail(@RequestBody BookPostDetail bookPostDetail) {
		return bookPostDetailService.saveBookPostDetail(bookPostDetail);
	}

	@PutMapping("/update")
	public String updateBookPostDetail(@RequestBody BookPostDetail bookPostDetail) {
		return bookPostDetailService.updateBookPostDetail(bookPostDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBookPostDetail(@PathVariable Integer id) {
		return bookPostDetailService.deleteOneBookPostDetail(id);
	}
}
