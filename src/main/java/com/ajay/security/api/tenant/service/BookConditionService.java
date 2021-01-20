package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BookCondition;
import com.ajay.security.api.tenant.repository.BookConditionRepository;

@Service
public class BookConditionService {

	@Autowired
	private BookConditionRepository bookConditionRepository;

	public List<BookCondition> getAllBookConditions() {
		return bookConditionRepository.findAll();
	}

	public BookCondition getOneBookCondition(Integer id) {
		return bookConditionRepository.findById(id).get();
	}

	public String saveBookCondition(BookCondition bookCondition) {
		return bookConditionRepository.save(bookCondition) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateBookCondition(BookCondition bookCondition) {
		return bookConditionRepository.save(bookCondition) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneBookCondition(Integer id) {
		bookConditionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
