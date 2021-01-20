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

import com.ajay.security.api.tenant.entity.BillItem;
import com.ajay.security.api.tenant.service.BillItemService;

@RestController
@RequestMapping("/billItem")
public class BillItemController {

	@Autowired
	private BillItemService billItemService;

	@GetMapping("/all")
	public List<BillItem> getAllBillItem() {
		return billItemService.getAllBillItems();
	}

	@GetMapping("/one/{id}")
	public BillItem getOneBillItem(@PathVariable Integer id) {
		return billItemService.getOneBillItem(id);
	}

	@PostMapping("/save")
	public String saveBillItem(@RequestBody BillItem billItem) {
		return billItemService.saveBillItem(billItem);
	}

	@PutMapping("/update")
	public String updateBillItem(@RequestBody BillItem billItem) {
		return billItemService.updateBillItem(billItem);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBillItem(@PathVariable Integer id) {
		return billItemService.deleteOneBillItem(id);
	}
}
