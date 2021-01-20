package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BookPost;
import com.ajay.security.api.tenant.repository.BookPostRepository;

@Service
public class BookPostService {

	@Autowired
	private BookPostRepository bookPostRepository;

	public List<BookPost> getAllBookPosts() {
		return bookPostRepository.findAll();
	}

	public BookPost getOneBookPost(Integer id) {
		return bookPostRepository.findById(id).get();
	}

	public String saveBookPost(BookPost bookPost) {
		return bookPostRepository.save(bookPost) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBookPost(BookPost bookPost) {
		return bookPostRepository.save(bookPost) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBookPost(Integer id) {
		bookPostRepository.deleteById(id);
		return " successfully deleted!";
	}
}
