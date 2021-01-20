package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BookPostDetail;
import com.ajay.security.api.tenant.repository.BookPostDetailRepository;

@Service
public class BookPostDetailService {

	@Autowired
	private BookPostDetailRepository bookPostDetailRepository;

	public List<BookPostDetail> getAllBookPostDetails() {
		return bookPostDetailRepository.findAll();
	}

	public BookPostDetail getOneBookPostDetail(Integer id) {
		return bookPostDetailRepository.findById(id).get();
	}

	public String saveBookPostDetail(BookPostDetail bookPostDetail) {
		return bookPostDetailRepository.save(bookPostDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateBookPostDetail(BookPostDetail bookPostDetail) {
		return bookPostDetailRepository.save(bookPostDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneBookPostDetail(Integer id) {
		bookPostDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
