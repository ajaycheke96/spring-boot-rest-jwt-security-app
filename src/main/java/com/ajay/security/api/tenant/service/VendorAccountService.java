package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.VendorAccount;
import com.ajay.security.api.tenant.repository.VendorAccountRepository;

@Service
@Transactional
public class VendorAccountService {

	@Autowired
	private VendorAccountRepository vendorAccountRepository;

	public List<VendorAccount> getAllVendorAccounts() {
		return vendorAccountRepository.findAll();
	}

	public VendorAccount getOneVendorAccount(Integer id) {
		return vendorAccountRepository.findById(id).get();
	}

	public String saveVendorAccount(VendorAccount vendorAccount) {
		return vendorAccountRepository.save(vendorAccount) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateVendorAccount(VendorAccount vendorAccount) {
		return vendorAccountRepository.save(vendorAccount) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneVendorAccount(Integer id) {
		vendorAccountRepository.deleteById(id);
		return " successfully deleted!";
	}
}
