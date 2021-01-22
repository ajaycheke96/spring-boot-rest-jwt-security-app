package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Vendor;
import com.ajay.security.api.tenant.repository.VendorRepository;

@Service
@Transactional
public class VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	public List<Vendor> getAllVendors() {
		return vendorRepository.findAll();
	}

	public Vendor getOneVendor(Integer id) {
		return vendorRepository.findById(id).get();
	}

	public String saveVendor(Vendor vendor) {
		return vendorRepository.save(vendor) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateVendor(Vendor vendor) {
		return vendorRepository.save(vendor) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneVendor(Integer id) {
		vendorRepository.deleteById(id);
		return " successfully deleted!";
	}
}
