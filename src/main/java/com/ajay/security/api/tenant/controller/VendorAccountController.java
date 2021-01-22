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

import com.ajay.security.api.tenant.entity.VendorAccount;
import com.ajay.security.api.tenant.service.VendorAccountService;

@RestController
@RequestMapping("/vendorAccount")
public class VendorAccountController {

	@Autowired
	private VendorAccountService vendorAccountService;

	@GetMapping("/all")
	public List<VendorAccount> getAllVendorAccount() {
		return vendorAccountService.getAllVendorAccounts();
	}

	@GetMapping("/one/{id}")
	public VendorAccount getOneVendorAccount(@PathVariable Integer id) {
		return vendorAccountService.getOneVendorAccount(id);
	}

	@PostMapping("/save")
	public String saveVendorAccount(@RequestBody VendorAccount vendorAccount) {
		return vendorAccountService.saveVendorAccount(vendorAccount);
	}

	@PutMapping("/update")
	public String updateVendorAccount(@RequestBody VendorAccount vendorAccount) {
		return vendorAccountService.updateVendorAccount(vendorAccount);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVendorAccount(@PathVariable Integer id) {
		return vendorAccountService.deleteOneVendorAccount(id);
	}
}
