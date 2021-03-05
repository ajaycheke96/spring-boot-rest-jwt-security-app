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

import com.ajay.security.api.tenant.entity.TransactionCategory;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TransactionCategoryService;

@RestController
@RequestMapping("/transactionCategory")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransactionCategoryController {

	@Autowired
	private TransactionCategoryService transactionCategoryService;

	@GetMapping("/listAllTransactionCategory")
	public ApiResponse getAllTransactionCategory() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of TransactionCategory",
					transactionCategoryService.getAllTransactionCategorys());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransactionCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTransactionCategory(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransactionCategory",
					transactionCategoryService.getOneTransactionCategory(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransactionCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTransactionCategory")
	public ApiResponse saveTransactionCategory(@RequestBody TransactionCategory transactionCategory) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransactionCategory saved!",
					transactionCategoryService.saveTransactionCategory(transactionCategory));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransactionCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTransactionCategory")
	public ApiResponse updateTransactionCategory(@RequestBody TransactionCategory transactionCategory) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TransactionCategory updated!",
					transactionCategoryService.saveTransactionCategory(transactionCategory));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransactionCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTransactionCategory")
	public ApiResponse deleteOneTransactionCategory(@RequestBody TransactionCategory transactionCategory) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					transactionCategoryService.deleteOneTransactionCategory(transactionCategory), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TransactionCategory Service exception : " + e.getLocalizedMessage());
		}
	}
}
