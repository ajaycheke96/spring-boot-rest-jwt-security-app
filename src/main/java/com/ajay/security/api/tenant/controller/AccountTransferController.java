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

import com.ajay.security.api.tenant.entity.AccountTransfer;
import com.ajay.security.api.tenant.service.AccountTransferService;

@RestController
@RequestMapping("/accountTransfer")
public class AccountTransferController {

	@Autowired
	private AccountTransferService accountTransferService;

	@GetMapping("/all")
	public List<AccountTransfer> getAllAccountTransfer() {
		return accountTransferService.getAllAccountTransfers();
	}

	@GetMapping("/one/{id}")
	public AccountTransfer getOneAccountTransfer(@PathVariable Integer id) {
		return accountTransferService.getOneAccountTransfer(id);
	}

	@PostMapping("/save")
	public String saveAccountTransfer(@RequestBody AccountTransfer accountTransfer) {
		return accountTransferService.saveAccountTransfer(accountTransfer);
	}

	@PutMapping("/update")
	public String updateAccountTransfer(@RequestBody AccountTransfer accountTransfer) {
		return accountTransferService.updateAccountTransfer(accountTransfer);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneAccountTransfer(@PathVariable Integer id) {
		return accountTransferService.deleteOneAccountTransfer(id);
	}
}
