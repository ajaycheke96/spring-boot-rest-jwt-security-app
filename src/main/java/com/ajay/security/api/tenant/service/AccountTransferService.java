package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.AccountTransfer;
import com.ajay.security.api.tenant.repository.AccountTransferRepository;

@Service
public class AccountTransferService {

	@Autowired
	private AccountTransferRepository accountTransferRepository;

	public List<AccountTransfer> getAllAccountTransfers() {
		return accountTransferRepository.findAll();
	}

	public AccountTransfer getOneAccountTransfer(Integer id) {
		return accountTransferRepository.findById(id).get();
	}

	public String saveAccountTransfer(AccountTransfer accountTransfer) {
		return accountTransferRepository.save(accountTransfer) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateAccountTransfer(AccountTransfer accountTransfer) {
		return accountTransferRepository.save(accountTransfer) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneAccountTransfer(Integer id) {
		accountTransferRepository.deleteById(id);
		return " successfully deleted!";
	}
}
