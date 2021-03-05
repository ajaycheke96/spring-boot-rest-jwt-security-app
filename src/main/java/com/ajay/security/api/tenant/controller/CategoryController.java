package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Category;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/listAllCategory")
	public ApiResponse getAllCategory() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Category",
					categoryService.getAllCategorys());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Category Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneCategory(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Category", categoryService.getOneCategory(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Category Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveCategory")
	public ApiResponse saveCategory(@RequestBody Category category) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Category saved!",
					categoryService.saveCategory(category));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Category Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateCategory")
	public ApiResponse updateCategory(@RequestBody Category category) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Category updated!",
					categoryService.saveCategory(category));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Category Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteCategory")
	public ApiResponse deleteOneCategory(@RequestBody Category category) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, categoryService.deleteOneCategory(category), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Category Service exception : " + e.getLocalizedMessage());
		}
	}
}
