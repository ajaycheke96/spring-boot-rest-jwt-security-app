package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TransactionCategory;
import com.ajay.security.api.tenant.repository.TransactionCategoryRepository;

@Service
@Transactional
public class TransactionCategoryService {

	@Autowired
	private TransactionCategoryRepository transactionCategoryRepository;

	public List<TransactionCategory> getAllTransactionCategorys() {
		return transactionCategoryRepository.findAll();
	}

	public TransactionCategory getOneTransactionCategory(Integer id) {
		return transactionCategoryRepository.findById(id).get();
	}

	public String saveTransactionCategory(TransactionCategory transactionCategory) {
		return transactionCategoryRepository.save(transactionCategory) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTransactionCategory(TransactionCategory transactionCategory) {
		return transactionCategoryRepository.save(transactionCategory) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransactionCategory(Integer id) {
		transactionCategoryRepository.deleteById(id);
		return " successfully deleted!";
	}
}
