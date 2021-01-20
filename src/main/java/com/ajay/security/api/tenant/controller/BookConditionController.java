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

import com.ajay.security.api.tenant.entity.BookCondition;
import com.ajay.security.api.tenant.service.BookConditionService;

@RestController
@RequestMapping("/bookCondition")
public class BookConditionController {

	@Autowired
	private BookConditionService bookConditionService;

	@GetMapping("/all")
	public List<BookCondition> getAllBookCondition() {
		return bookConditionService.getAllBookConditions();
	}

	@GetMapping("/one/{id}")
	public BookCondition getOneBookCondition(@PathVariable Integer id) {
		return bookConditionService.getOneBookCondition(id);
	}

	@PostMapping("/save")
	public String saveBookCondition(@RequestBody BookCondition bookCondition) {
		return bookConditionService.saveBookCondition(bookCondition);
	}

	@PutMapping("/update")
	public String updateBookCondition(@RequestBody BookCondition bookCondition) {
		return bookConditionService.updateBookCondition(bookCondition);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBookCondition(@PathVariable Integer id) {
		return bookConditionService.deleteOneBookCondition(id);
	}
}
