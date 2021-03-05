package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.AccountTransfer;
import com.ajay.security.api.tenant.repository.AccountTransferRepository;

@Service
@Transactional
public class AccountTransferService {

	@Autowired
	private AccountTransferRepository accountTransferRepository;

	public List<AccountTransfer> getAllAccountTransfers() {
		return accountTransferRepository.findAll();
	}

	public AccountTransfer getOneAccountTransfer(Integer id) {
		return accountTransferRepository.findById(id).get();
	}

	public AccountTransfer saveAccountTransfer(AccountTransfer accountTransfer) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (accountTransfer.getCreatedAt() == null)
			accountTransfer.setCreatedAt(currentTimestamp);
		accountTransfer.setUpdatedAt(currentTimestamp);
		return accountTransferRepository.save(accountTransfer);
	}

	public String deleteOneAccountTransfer(AccountTransfer accountTransfer) {
		String result = null;
		if (accountTransferRepository.existsById(accountTransfer.getId())) {
			accountTransferRepository.delete(accountTransfer);
			result = " AccountTransfer deleted!";
		} else {
			result = "AccountTransfer Not Found! or Already deleted!";
		}
		return result;
	}
}
