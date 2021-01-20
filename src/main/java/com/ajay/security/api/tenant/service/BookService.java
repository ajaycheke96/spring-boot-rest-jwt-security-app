package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Book;
import com.ajay.security.api.tenant.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getOneBook(Integer id) {
		return bookRepository.findById(id).get();
	}

	public String saveBook(Book book) {
		return bookRepository.save(book) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBook(Book book) {
		return bookRepository.save(book) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBook(Integer id) {
		bookRepository.deleteById(id);
		return " successfully deleted!";
	}
}
