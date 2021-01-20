package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BookLogDetail;
import com.ajay.security.api.tenant.repository.BookLogDetailRepository;

@Service
public class BookLogDetailService {

	@Autowired
	private BookLogDetailRepository bookLogDetailRepository;

	public List<BookLogDetail> getAllBookLogDetails() {
		return bookLogDetailRepository.findAll();
	}

	public BookLogDetail getOneBookLogDetail(Integer id) {
		return bookLogDetailRepository.findById(id).get();
	}

	public String saveBookLogDetail(BookLogDetail bookLogDetail) {
		return bookLogDetailRepository.save(bookLogDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateBookLogDetail(BookLogDetail bookLogDetail) {
		return bookLogDetailRepository.save(bookLogDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneBookLogDetail(Integer id) {
		bookLogDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
