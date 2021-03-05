package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Account saveAccount(Account account) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (account.getCreatedAt() == null)
			account.setCreatedAt(currentTimestamp);
		account.setUpdatedAt(currentTimestamp);
		return accountRepository.save(account);
	}

	public String deleteOneAccount(Account account) {
		String result = null;
		if (accountRepository.existsById(account.getId())) {
			accountRepository.delete(account);
			result = " Account deleted!";
		} else {
			result = "Account Not Found! or Already deleted!";
		}
		return result;
	}
}
