package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BookLog;
import com.ajay.security.api.tenant.repository.BookLogRepository;

@Service
public class BookLogService {

	@Autowired
	private BookLogRepository bookLogRepository;

	public List<BookLog> getAllBookLogs() {
		return bookLogRepository.findAll();
	}

	public BookLog getOneBookLog(Integer id) {
		return bookLogRepository.findById(id).get();
	}

	public String saveBookLog(BookLog bookLog) {
		return bookLogRepository.save(bookLog) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBookLog(BookLog bookLog) {
		return bookLogRepository.save(bookLog) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBookLog(Integer id) {
		bookLogRepository.deleteById(id);
		return " successfully deleted!";
	}
}
