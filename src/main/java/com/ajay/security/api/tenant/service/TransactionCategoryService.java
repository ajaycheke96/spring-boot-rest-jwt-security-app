package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public TransactionCategory saveTransactionCategory(TransactionCategory transactionCategory) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (transactionCategory.getCreatedAt() == null)
			transactionCategory.setCreatedAt(currentTimestamp);
		transactionCategory.setUpdatedAt(currentTimestamp);
		return transactionCategoryRepository.save(transactionCategory);
	}

	public String deleteOneTransactionCategory(TransactionCategory transactionCategory) {
		String result = null;
		if (transactionCategoryRepository.existsById(transactionCategory.getId())) {
			transactionCategoryRepository.delete(transactionCategory);
			result = " TransactionCategory deleted!";
		} else {
			result = "TransactionCategory Not Found! or Already deleted!";
		}
		return result;
	}
}
