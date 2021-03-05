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

import com.ajay.security.api.tenant.entity.Vendor;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.VendorService;

@RestController
@RequestMapping("/vendor")
@CrossOrigin(origins = "*", maxAge = 3600)
public class VendorController {

	@Autowired
	private VendorService vendorService;

	@GetMapping("/listAllVendor")
	public ApiResponse getAllVendor() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Vendor", vendorService.getAllVendors());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vendor Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneVendor(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Vendor", vendorService.getOneVendor(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vendor Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveVendor")
	public ApiResponse saveVendor(@RequestBody Vendor vendor) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Vendor saved!", vendorService.saveVendor(vendor));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vendor Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateVendor")
	public ApiResponse updateVendor(@RequestBody Vendor vendor) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Vendor updated!", vendorService.saveVendor(vendor));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vendor Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteVendor")
	public ApiResponse deleteOneVendor(@RequestBody Vendor vendor) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, vendorService.deleteOneVendor(vendor), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Vendor Service exception : " + e.getLocalizedMessage());
		}
	}
}
