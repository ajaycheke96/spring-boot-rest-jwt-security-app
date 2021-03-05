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

import com.ajay.security.api.tenant.entity.Transaction;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/listAllTransaction")
	public ApiResponse getAllTransaction() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Transaction",
					transactionService.getAllTransactions());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Transaction Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTransaction(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Transaction",
					transactionService.getOneTransaction(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Transaction Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTransaction")
	public ApiResponse saveTransaction(@RequestBody Transaction transaction) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Transaction saved!",
					transactionService.saveTransaction(transaction));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Transaction Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTransaction")
	public ApiResponse updateTransaction(@RequestBody Transaction transaction) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Transaction updated!",
					transactionService.saveTransaction(transaction));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Transaction Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTransaction")
	public ApiResponse deleteOneTransaction(@RequestBody Transaction transaction) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, transactionService.deleteOneTransaction(transaction),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Transaction Service exception : " + e.getLocalizedMessage());
		}
	}
}
