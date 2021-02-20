package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Book;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/listAllBook")
	public ApiResponse getAllBook() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Book", bookService.getAllBooks());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Book Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/{id}")
	public ApiResponse getOneBook(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Book", bookService.getOneBook(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Book Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveBook", method = RequestMethod.POST)
	public ApiResponse saveBook(@RequestBody Book book) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Book saved!", bookService.saveBook(book));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Book Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateBook", method = RequestMethod.POST)
	public ApiResponse updateBook(@RequestBody Book book) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Book updated!", bookService.saveBook(book));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Book Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteBook", method = RequestMethod.POST)
	public ApiResponse deleteOneBook(@RequestBody Book book) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Book deleted!", bookService.deleteOneBook(book));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Book Service exception : " + e.getLocalizedMessage());
		}
	}
}
