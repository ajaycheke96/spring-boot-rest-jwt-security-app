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

import com.ajay.security.api.tenant.entity.StockTransfer;
import com.ajay.security.api.tenant.service.StockTransferService;

@RestController
@RequestMapping("/stockTransfer")
public class StockTransferController {

	@Autowired
	private StockTransferService stockTransferService;

	@GetMapping("/all")
	public List<StockTransfer> getAllStockTransfer() {
		return stockTransferService.getAllStockTransfers();
	}

	@GetMapping("/one/{id}")
	public StockTransfer getOneStockTransfer(@PathVariable Integer id) {
		return stockTransferService.getOneStockTransfer(id);
	}

	@PostMapping("/save")
	public String saveStockTransfer(@RequestBody StockTransfer stockTransfer) {
		return stockTransferService.saveStockTransfer(stockTransfer);
	}

	@PutMapping("/update")
	public String updateStockTransfer(@RequestBody StockTransfer stockTransfer) {
		return stockTransferService.updateStockTransfer(stockTransfer);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStockTransfer(@PathVariable Integer id) {
		return stockTransferService.deleteOneStockTransfer(id);
	}
}
