package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.Bill;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.BillService;

@RestController
@RequestMapping("/bill")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BillController {

	@Autowired
	private BillService billService;

	@RequestMapping(value = "/listAllBill")
	public ApiResponse getAllBill() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Bill", billService.getAllBills());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Bill Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/{id}")
	public ApiResponse getOneBill(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Bill", billService.getOneBill(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Bill Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/saveBill", method = RequestMethod.POST)
	public ApiResponse saveBill(@RequestBody Bill bill) throws Exception {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Bill saved!", billService.saveBill(bill));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Bill Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/updateBill", method = RequestMethod.POST)
	public ApiResponse updateBill(@RequestBody Bill bill) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Bill updated!", billService.saveBill(bill));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Bill Service exception : " + e.getLocalizedMessage());
		}
	}

	@RequestMapping(value = "/deleteBill", method = RequestMethod.POST)
	public ApiResponse deleteOneBill(@RequestBody Bill bill) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, billService.deleteOneBill(bill), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Bill Service exception : " + e.getLocalizedMessage());
		}
	}
}
