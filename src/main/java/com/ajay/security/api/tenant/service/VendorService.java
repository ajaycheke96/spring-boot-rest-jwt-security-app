package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Vendor saveVendor(Vendor vendor) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (vendor.getCreatedAt() == null)
			vendor.setCreatedAt(currentTimestamp);
		vendor.setUpdatedAt(currentTimestamp);

		// For VendorAccounts list
		if (!vendor.getVendorAccounts().isEmpty())
			vendor.getVendorAccounts().forEach(vendorAccount -> {
				if (vendorAccount.getCreatedAt() == null)
					vendorAccount.setCreatedAt(currentTimestamp);
				vendorAccount.setUpdatedAt(currentTimestamp);
			});
		return vendorRepository.save(vendor);
	}

	public String deleteOneVendor(Vendor vendor) {
		String result = null;
		if (vendorRepository.existsById(vendor.getId())) {
			vendorRepository.delete(vendor);
			result = " Vendor deleted!";
		} else {
			result = "Vendor Not Found! or Already deleted!";
		}
		return result;
	}
}
