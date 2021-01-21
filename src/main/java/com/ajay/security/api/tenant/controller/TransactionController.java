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

import com.ajay.security.api.tenant.entity.Transaction;
import com.ajay.security.api.tenant.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/all")
	public List<Transaction> getAllTransaction() {
		return transactionService.getAllTransactions();
	}

	@GetMapping("/one/{id}")
	public Transaction getOneTransaction(@PathVariable Integer id) {
		return transactionService.getOneTransaction(id);
	}

	@PostMapping("/save")
	public String saveTransaction(@RequestBody Transaction transaction) {
		return transactionService.saveTransaction(transaction);
	}

	@PutMapping("/update")
	public String updateTransaction(@RequestBody Transaction transaction) {
		return transactionService.updateTransaction(transaction);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransaction(@PathVariable Integer id) {
		return transactionService.deleteOneTransaction(id);
	}
}
