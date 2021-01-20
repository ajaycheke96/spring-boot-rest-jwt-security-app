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

import com.ajay.security.api.tenant.entity.Book;
import com.ajay.security.api.tenant.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/all")
	public List<Book> getAllBook() {
		return bookService.getAllBooks();
	}

	@GetMapping("/one/{id}")
	public Book getOneBook(@PathVariable Integer id) {
		return bookService.getOneBook(id);
	}

	@PostMapping("/save")
	public String saveBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}

	@PutMapping("/update")
	public String updateBook(@RequestBody Book book) {
		return bookService.updateBook(book);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBook(@PathVariable Integer id) {
		return bookService.deleteOneBook(id);
	}
}
