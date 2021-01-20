package com.ajay.security.api.tenant.service;

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

	public String saveExpense(Expense expense) {
		return expenseRepository.save(expense) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateExpense(Expense expense) {
		return expenseRepository.save(expense) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneExpense(Integer id) {
		expenseRepository.deleteById(id);
		return " successfully deleted!";
	}
}
