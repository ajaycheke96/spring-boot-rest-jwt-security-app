package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Account;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.AccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/listAllAccount")
	public ApiResponse getAllAccounts() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Account", accountService.getAllAccounts());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Account Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneAccount(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Account", accountService.getOneAccount(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Account Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveAccount")
	public ApiResponse saveAccount(@RequestBody Account account) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Account saved!",
					accountService.saveAccount(account));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Account Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateAccount")
	public ApiResponse updateAccount(@RequestBody Account account) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Account updated!",
					accountService.saveAccount(account));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Account Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteAccount")
	public ApiResponse deleteOneAccount(@RequestBody Account account) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, accountService.deleteOneAccount(account), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Account Service exception : " + e.getLocalizedMessage());
		}
	}
}
