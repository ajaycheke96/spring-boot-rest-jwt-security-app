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

import com.ajay.security.api.tenant.entity.Account;
import com.ajay.security.api.tenant.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/all")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/one/{id}")
	public Account getOneAccount(@PathVariable Integer id) {
		return accountService.getOneAccount(id);
	}

	@PostMapping("/save")
	public String saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}

	@PutMapping("/update")
	public String updateAccount(@RequestBody Account account) {
		return accountService.updateAccount(account);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneAccount(@PathVariable Integer id) {
		return accountService.deleteOneAccount(id);
	}
}
