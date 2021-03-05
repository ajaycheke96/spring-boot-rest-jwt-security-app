package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Expense;
import com.ajay.security.api.tenant.repository.ExpenseRepository;

@Service
@Transactional
public class ExpenseService {

	@Autowired
	private ExpenseRepository expenseRepository;

	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}

	public Expense getOneExpense(Integer id) {
		return expenseRepository.findById(id).get();
	}

	public Expense saveExpense(Expense expense) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (expense.getCreatedAt() == null)
			expense.setCreatedAt(currentTimestamp);
		expense.setUpdatedAt(currentTimestamp);
		return expenseRepository.save(expense);
	}

	public String deleteOneExpense(Expense expense) {
		String result = null;
		if (expenseRepository.existsById(expense.getId())) {
			expenseRepository.delete(expense);
			result = " Expense deleted!";
		} else {
			result = "Expense Not Found! or Already deleted!";
		}
		return result;
	}
}
