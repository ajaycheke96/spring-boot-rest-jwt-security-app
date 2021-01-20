package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BookAuthor;
import com.ajay.security.api.tenant.repository.BookAuthorRepository;

@Service
public class BookAuthorService {

	@Autowired
	private BookAuthorRepository bookAuthorRepository;

	public List<BookAuthor> getAllBookAuthors() {
		return bookAuthorRepository.findAll();
	}

	public BookAuthor getOneBookAuthor(Integer id) {
		return bookAuthorRepository.findById(id).get();
	}

	public String saveBookAuthor(BookAuthor bookAuthor) {
		return bookAuthorRepository.save(bookAuthor) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBookAuthor(BookAuthor bookAuthor) {
		return bookAuthorRepository.save(bookAuthor) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBookAuthor(Integer id) {
		bookAuthorRepository.deleteById(id);
		return " successfully deleted!";
	}
}
