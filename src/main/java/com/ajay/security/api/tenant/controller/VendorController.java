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

import com.ajay.security.api.tenant.entity.Vendor;
import com.ajay.security.api.tenant.service.VendorService;

@RestController
@RequestMapping("/vendor")
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@GetMapping("/all")
	public List<Vendor> getAllVendor() {
		return vendorService.getAllVendors();
	}

	@GetMapping("/one/{id}")
	public Vendor getOneVendor(@PathVariable Integer id) {
		return vendorService.getOneVendor(id);
	}

	@PostMapping("/save")
	public String saveVendor(@RequestBody Vendor vendor) {
		return vendorService.saveVendor(vendor);
	}

	@PutMapping("/update")
	public String updateVendor(@RequestBody Vendor vendor) {
		return vendorService.updateVendor(vendor);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneVendor(@PathVariable Integer id) {
		return vendorService.deleteOneVendor(id);
	}
}
