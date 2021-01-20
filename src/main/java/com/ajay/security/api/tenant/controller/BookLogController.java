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

import com.ajay.security.api.tenant.entity.BookLog;
import com.ajay.security.api.tenant.service.BookLogService;

@RestController
@RequestMapping("/bookLog")
public class BookLogController {

	@Autowired
	private BookLogService bookLogService;

	@GetMapping("/all")
	public List<BookLog> getAllBookLog() {
		return bookLogService.getAllBookLogs();
	}

	@GetMapping("/one/{id}")
	public BookLog getOneBookLog(@PathVariable Integer id) {
		return bookLogService.getOneBookLog(id);
	}

	@PostMapping("/save")
	public String saveBookLog(@RequestBody BookLog bookLog) {
		return bookLogService.saveBookLog(bookLog);
	}

	@PutMapping("/update")
	public String updateBookLog(@RequestBody BookLog bookLog) {
		return bookLogService.updateBookLog(bookLog);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBookLog(@PathVariable Integer id) {
		return bookLogService.deleteOneBookLog(id);
	}
}
