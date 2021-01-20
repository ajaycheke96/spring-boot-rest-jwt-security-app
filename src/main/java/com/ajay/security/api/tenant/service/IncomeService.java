package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Income;
import com.ajay.security.api.tenant.repository.IncomeRepository;

@Service
@Transactional
public class IncomeService {

	@Autowired
	private IncomeRepository incomeRepository;

	public List<Income> getAllIncomes() {
		return incomeRepository.findAll();
	}

	public Income getOneIncome(Integer id) {
		return incomeRepository.findById(id).get();
	}

	public String saveIncome(Income income) {
		return incomeRepository.save(income) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateIncome(Income income) {
		return incomeRepository.save(income) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneIncome(Integer id) {
		incomeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
