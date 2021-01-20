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

import com.ajay.security.api.tenant.entity.BookLogDetail;
import com.ajay.security.api.tenant.service.BookLogDetailService;

@RestController
@RequestMapping("/bookLogDetail")
public class BookLogDetailController {

	@Autowired
	private BookLogDetailService bookLogDetailService;

	@GetMapping("/all")
	public List<BookLogDetail> getAllBookLogDetail() {
		return bookLogDetailService.getAllBookLogDetails();
	}

	@GetMapping("/one/{id}")
	public BookLogDetail getOneBookLogDetail(@PathVariable Integer id) {
		return bookLogDetailService.getOneBookLogDetail(id);
	}

	@PostMapping("/save")
	public String saveBookLogDetail(@RequestBody BookLogDetail bookLogDetail) {
		return bookLogDetailService.saveBookLogDetail(bookLogDetail);
	}

	@PutMapping("/update")
	public String updateBookLogDetail(@RequestBody BookLogDetail bookLogDetail) {
		return bookLogDetailService.updateBookLogDetail(bookLogDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBookLogDetail(@PathVariable Integer id) {
		return bookLogDetailService.deleteOneBookLogDetail(id);
	}
}
