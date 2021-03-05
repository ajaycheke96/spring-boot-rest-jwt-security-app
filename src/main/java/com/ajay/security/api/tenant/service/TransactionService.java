package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Transaction saveTransaction(Transaction transaction) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (transaction.getCreatedAt() == null)
			transaction.setCreatedAt(currentTimestamp);
		transaction.setUpdatedAt(currentTimestamp);

		if (transaction.getTransaction().getCreatedAt() == null)
			transaction.getTransaction().setCreatedAt(currentTimestamp);
		transaction.getTransaction().setUpdatedAt(currentTimestamp);
		return transactionRepository.save(transaction);
	}

	public String deleteOneTransaction(Transaction transaction) {
		String result = null;
		if (transactionRepository.existsById(transaction.getId())) {
			transactionRepository.delete(transaction);
			result = " Transaction deleted!";
		} else {
			result = "Transaction Not Found! or Already deleted!";
		}
		return result;
	}
}
