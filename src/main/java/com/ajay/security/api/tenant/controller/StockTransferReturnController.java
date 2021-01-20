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

import com.ajay.security.api.tenant.entity.StockTransferReturn;
import com.ajay.security.api.tenant.service.StockTransferReturnService;

@RestController
@RequestMapping("/stockTransferReturn")
public class StockTransferReturnController {

	@Autowired
	private StockTransferReturnService stockTransferReturnService;

	@GetMapping("/all")
	public List<StockTransferReturn> getAllStockTransferReturn() {
		return stockTransferReturnService.getAllStockTransferReturns();
	}

	@GetMapping("/one/{id}")
	public StockTransferReturn getOneStockTransferReturn(@PathVariable Integer id) {
		return stockTransferReturnService.getOneStockTransferReturn(id);
	}

	@PostMapping("/save")
	public String saveStockTransferReturn(@RequestBody StockTransferReturn stockTransferReturn) {
		return stockTransferReturnService.saveStockTransferReturn(stockTransferReturn);
	}

	@PutMapping("/update")
	public String updateStockTransferReturn(@RequestBody StockTransferReturn stockTransferReturn) {
		return stockTransferReturnService.updateStockTransferReturn(stockTransferReturn);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStockTransferReturn(@PathVariable Integer id) {
		return stockTransferReturnService.deleteOneStockTransferReturn(id);
	}
}
