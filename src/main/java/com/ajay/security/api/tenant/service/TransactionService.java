package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Transaction;
import com.ajay.security.api.tenant.repository.TransactionRepository;

@Service
@Transactional
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Transaction getOneTransaction(Integer id) {
		return transactionRepository.findById(id).get();
	}

	public String saveTransaction(Transaction transaction) {
		return transactionRepository.save(transaction) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateTransaction(Transaction transaction) {
		return transactionRepository.save(transaction) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransaction(Integer id) {
		transactionRepository.deleteById(id);
		return " successfully deleted!";
	}
}
