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

import com.ajay.security.api.tenant.entity.Expense;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ExpenseService;

@RestController
@RequestMapping("/expense")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/listAllExpense")
	public ApiResponse getAllExpense() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Expense", expenseService.getAllExpenses());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Expense Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneExpense(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Expense", expenseService.getOneExpense(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Expense Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveExpense")
	public ApiResponse saveExpense(@RequestBody Expense expense) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Expense saved!",
					expenseService.saveExpense(expense));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Expense Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateExpense")
	public ApiResponse updateExpense(@RequestBody Expense expense) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Expense updated!",
					expenseService.saveExpense(expense));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Expense Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteExpense")
	public ApiResponse deleteOneExpense(@RequestBody Expense expense) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, expenseService.deleteOneExpense(expense), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Expense Service exception : " + e.getLocalizedMessage());
		}
	}
}
