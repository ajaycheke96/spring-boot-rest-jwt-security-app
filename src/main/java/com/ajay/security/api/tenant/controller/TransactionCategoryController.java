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

import com.ajay.security.api.tenant.entity.TransactionCategory;
import com.ajay.security.api.tenant.service.TransactionCategoryService;

@RestController
@RequestMapping("/transactionCategory")
public class TransactionCategoryController {

	@Autowired
	private TransactionCategoryService transactionCategoryService;

	@GetMapping("/all")
	public List<TransactionCategory> getAllTransactionCategory() {
		return transactionCategoryService.getAllTransactionCategorys();
	}

	@GetMapping("/one/{id}")
	public TransactionCategory getOneTransactionCategory(@PathVariable Integer id) {
		return transactionCategoryService.getOneTransactionCategory(id);
	}

	@PostMapping("/save")
	public String saveTransactionCategory(@RequestBody TransactionCategory transactionCategory) {
		return transactionCategoryService.saveTransactionCategory(transactionCategory);
	}

	@PutMapping("/update")
	public String updateTransactionCategory(@RequestBody TransactionCategory transactionCategory) {
		return transactionCategoryService.updateTransactionCategory(transactionCategory);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransactionCategory(@PathVariable Integer id) {
		return transactionCategoryService.deleteOneTransactionCategory(id);
	}
}
