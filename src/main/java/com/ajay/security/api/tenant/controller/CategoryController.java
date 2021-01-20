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

import com.ajay.security.api.tenant.entity.Category;
import com.ajay.security.api.tenant.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/all")
	public List<Category> getAllCategory() {
		return categoryService.getAllCategorys();
	}

	@GetMapping("/one/{id}")
	public Category getOneCategory(@PathVariable Integer id) {
		return categoryService.getOneCategory(id);
	}

	@PostMapping("/save")
	public String saveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}

	@PutMapping("/update")
	public String updateCategory(@RequestBody Category category) {
		return categoryService.updateCategory(category);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCategory(@PathVariable Integer id) {
		return categoryService.deleteOneCategory(id);
	}
}
