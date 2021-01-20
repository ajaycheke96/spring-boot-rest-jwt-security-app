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

import com.ajay.security.api.tenant.entity.StockTransferDetail;
import com.ajay.security.api.tenant.service.StockTransferDetailService;

@RestController
@RequestMapping("/stockTransferDetail")
public class StockTransferDetailController {

	@Autowired
	private StockTransferDetailService stockTransferDetailService;

	@GetMapping("/all")
	public List<StockTransferDetail> getAllStockTransferDetail() {
		return stockTransferDetailService.getAllStockTransferDetails();
	}

	@GetMapping("/one/{id}")
	public StockTransferDetail getOneStockTransferDetail(@PathVariable Integer id) {
		return stockTransferDetailService.getOneStockTransferDetail(id);
	}

	@PostMapping("/save")
	public String saveStockTransferDetail(@RequestBody StockTransferDetail stockTransferDetail) {
		return stockTransferDetailService.saveStockTransferDetail(stockTransferDetail);
	}

	@PutMapping("/update")
	public String updateStockTransferDetail(@RequestBody StockTransferDetail stockTransferDetail) {
		return stockTransferDetailService.updateStockTransferDetail(stockTransferDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStockTransferDetail(@PathVariable Integer id) {
		return stockTransferDetailService.deleteOneStockTransferDetail(id);
	}
}
