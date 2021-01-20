package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Category;
import com.ajay.security.api.tenant.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> getAllCategorys() {
		return categoryRepository.findAll();
	}

	public Category getOneCategory(Integer id) {
		return categoryRepository.findById(id).get();
	}

	public String saveCategory(Category category) {
		return categoryRepository.save(category) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateCategory(Category category) {
		return categoryRepository.save(category) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneCategory(Integer id) {
		categoryRepository.deleteById(id);
		return " successfully deleted!";
	}
}
