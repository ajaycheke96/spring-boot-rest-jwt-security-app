package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BookPublisher;
import com.ajay.security.api.tenant.repository.BookPublisherRepository;
@Service
public class BookPublisherService {

	@Autowired
	private BookPublisherRepository bookPublisherRepository;

	public List<BookPublisher> getAllBookPublishers() {
		return bookPublisherRepository.findAll();
	}

	public BookPublisher getOneBookPublisher(Integer id) {
		return bookPublisherRepository.findById(id).get();
	}

	public String saveBookPublisher(BookPublisher bookPublisher) {
		return bookPublisherRepository.save(bookPublisher) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateBookPublisher(BookPublisher bookPublisher) {
		return bookPublisherRepository.save(bookPublisher) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneBookPublisher(Integer id) {
		bookPublisherRepository.deleteById(id);
		return " successfully deleted!";
	}
}
