package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Book;
import com.ajay.security.api.tenant.repository.BookRepository;

@Service
@Transactional
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getOneBook(Integer id) {
		return bookRepository.findById(id).get();
	}

	public Book saveBook(Book book) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (book.getCreatedAt() == null)
			book.setCreatedAt(currentTimestamp);
		book.setUpdatedAt(currentTimestamp);
		return bookRepository.save(book);
	}

	public String deleteOneBook(Book book) {
		String result = null;
		if (bookRepository.existsById(book.getId())) {
			bookRepository.delete(book);
			result = " Book deleted!";
		} else {
			result = "Book Not Found! or Already deleted!";
		}
		return result;
	}
}
