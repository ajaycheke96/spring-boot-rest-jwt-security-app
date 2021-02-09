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

import com.ajay.security.api.tenant.entity.Bill;
import com.ajay.security.api.tenant.service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {

	@Autowired
	private BillService billService;

	@GetMapping("/all")
	public List<Bill> getAllBill() {
		return billService.getAllBills();
	}

	@GetMapping("/one/{id}")
	public Bill getOneBill(@PathVariable Integer id) {
		return billService.getOneBill(id);
	}

	@PostMapping("/save")
	public String saveBill(@RequestBody Bill bill) throws Exception {
		return billService.saveBill(bill);
	}

	@PutMapping("/update")
	public String updateBill(@RequestBody Bill bill) {
		return billService.updateBill(bill);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBill(@PathVariable Integer id) {
		return billService.deleteOneBill(id);
	}
}
