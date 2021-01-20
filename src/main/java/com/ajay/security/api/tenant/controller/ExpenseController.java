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

import com.ajay.security.api.tenant.entity.Expense;
import com.ajay.security.api.tenant.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@GetMapping("/all")
	public List<Expense> getAllExpense() {
		return expenseService.getAllExpenses();
	}

	@GetMapping("/one/{id}")
	public Expense getOneExpense(@PathVariable Integer id) {
		return expenseService.getOneExpense(id);
	}

	@PostMapping("/save")
	public String saveExpense(@RequestBody Expense expense) {
		return expenseService.saveExpense(expense);
	}

	@PutMapping("/update")
	public String updateExpense(@RequestBody Expense expense) {
		return expenseService.updateExpense(expense);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneExpense(@PathVariable Integer id) {
		return expenseService.deleteOneExpense(id);
	}
}
