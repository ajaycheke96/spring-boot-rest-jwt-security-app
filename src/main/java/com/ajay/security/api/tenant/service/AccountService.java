package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Account;
import com.ajay.security.api.tenant.repository.AccountRepository;

@Service
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public Account getOneAccount(Integer id) {
		return accountRepository.findById(id).get();
	}
	
	public String saveAccount( Account account) {
		return accountRepository.save(account) != null ? "Account successfully saved!" : "Failed! Please try again!!";
	}

	public String updateAccount( Account account) {
		return accountRepository.save(account)!= null ? "Account successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneAccount(Integer id) {
		accountRepository.deleteById(id);
		return "Account successfully deleted!";
	}
}
