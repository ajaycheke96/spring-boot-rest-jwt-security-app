package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BookTopic;
import com.ajay.security.api.tenant.repository.BookTopicRepository;

@Service
public class BookTopicService {

	@Autowired
	private BookTopicRepository bookTopicRepository;

	public List<BookTopic> getAllBookTopics() {
		return bookTopicRepository.findAll();
	}

	public BookTopic getOneBookTopic(Integer id) {
		return bookTopicRepository.findById(id).get();
	}

	public String saveBookTopic(BookTopic bookTopic) {
		return bookTopicRepository.save(bookTopic) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBookTopic(BookTopic bookTopic) {
		return bookTopicRepository.save(bookTopic) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBookTopic(Integer id) {
		bookTopicRepository.deleteById(id);
		return " successfully deleted!";
	}
}
