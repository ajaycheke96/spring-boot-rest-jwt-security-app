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

import com.ajay.security.api.tenant.entity.StockPurchaseDetail;
import com.ajay.security.api.tenant.service.StockPurchaseDetailService;

@RestController
@RequestMapping("/stockPurchaseDetail")
public class StockPurchaseDetailController {

	@Autowired
	private StockPurchaseDetailService stockPurchaseDetailService;

	@GetMapping("/all")
	public List<StockPurchaseDetail> getAllStockPurchaseDetail() {
		return stockPurchaseDetailService.getAllStockPurchaseDetails();
	}

	@GetMapping("/one/{id}")
	public StockPurchaseDetail getOneStockPurchaseDetail(@PathVariable Integer id) {
		return stockPurchaseDetailService.getOneStockPurchaseDetail(id);
	}

	@PostMapping("/save")
	public String saveStockPurchaseDetail(@RequestBody StockPurchaseDetail stockPurchaseDetail) {
		return stockPurchaseDetailService.saveStockPurchaseDetail(stockPurchaseDetail);
	}

	@PutMapping("/update")
	public String updateStockPurchaseDetail(@RequestBody StockPurchaseDetail stockPurchaseDetail) {
		return stockPurchaseDetailService.updateStockPurchaseDetail(stockPurchaseDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStockPurchaseDetail(@PathVariable Integer id) {
		return stockPurchaseDetailService.deleteOneStockPurchaseDetail(id);
	}
}
