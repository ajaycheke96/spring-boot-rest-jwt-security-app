package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Category saveCategory(Category category) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (category.getCreatedAt() == null)
			category.setCreatedAt(currentTimestamp);
		category.setUpdatedAt(currentTimestamp);
		return categoryRepository.save(category);
	}

	public String deleteOneCategory(Category category) {
		String result = null;
		if (categoryRepository.existsById(category.getId())) {
			categoryRepository.delete(category);
			result = " Category deleted!";
		} else {
			result = "Category Not Found! or Already deleted!";
		}
		return result;
	}
}
