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

import com.ajay.security.api.tenant.entity.Income;
import com.ajay.security.api.tenant.service.IncomeService;

@RestController
@RequestMapping("/income")
public class IncomeController {

	@Autowired
	private IncomeService incomeService;

	@GetMapping("/all")
	public List<Income> getAllIncome() {
		return incomeService.getAllIncomes();
	}

	@GetMapping("/one/{id}")
	public Income getOneIncome(@PathVariable Integer id) {
		return incomeService.getOneIncome(id);
	}

	@PostMapping("/save")
	public String saveIncome(@RequestBody Income income) {
		return incomeService.saveIncome(income);
	}

	@PutMapping("/update")
	public String updateIncome(@RequestBody Income income) {
		return incomeService.updateIncome(income);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneIncome(@PathVariable Integer id) {
		return incomeService.deleteOneIncome(id);
	}
}
