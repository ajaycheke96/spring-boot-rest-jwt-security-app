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

import com.ajay.security.api.tenant.entity.StockPurchase;
import com.ajay.security.api.tenant.service.StockPurchaseService;

@RestController
@RequestMapping("/stockPurchase")
public class StockPurchaseController {

	@Autowired
	private StockPurchaseService stockPurchaseService;

	@GetMapping("/all")
	public List<StockPurchase> getAllStockPurchase() {
		return stockPurchaseService.getAllStockPurchases();
	}

	@GetMapping("/one/{id}")
	public StockPurchase getOneStockPurchase(@PathVariable Integer id) {
		return stockPurchaseService.getOneStockPurchase(id);
	}

	@PostMapping("/save")
	public String saveStockPurchase(@RequestBody StockPurchase stockPurchase) {
		return stockPurchaseService.saveStockPurchase(stockPurchase);
	}

	@PutMapping("/update")
	public String updateStockPurchase(@RequestBody StockPurchase stockPurchase) {
		return stockPurchaseService.updateStockPurchase(stockPurchase);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStockPurchase(@PathVariable Integer id) {
		return stockPurchaseService.deleteOneStockPurchase(id);
	}
}
