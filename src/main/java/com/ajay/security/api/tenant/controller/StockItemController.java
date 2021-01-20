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

import com.ajay.security.api.tenant.entity.StockItem;
import com.ajay.security.api.tenant.service.StockItemService;

@RestController
@RequestMapping("/stockItem")
public class StockItemController {

	@Autowired
	private StockItemService stockItemService;

	@GetMapping("/all")
	public List<StockItem> getAllStockItem() {
		return stockItemService.getAllStockItems();
	}

	@GetMapping("/one/{id}")
	public StockItem getOneStockItem(@PathVariable Integer id) {
		return stockItemService.getOneStockItem(id);
	}

	@PostMapping("/save")
	public String saveStockItem(@RequestBody StockItem stockItem) {
		return stockItemService.saveStockItem(stockItem);
	}

	@PutMapping("/update")
	public String updateStockItem(@RequestBody StockItem stockItem) {
		return stockItemService.updateStockItem(stockItem);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStockItem(@PathVariable Integer id) {
		return stockItemService.deleteOneStockItem(id);
	}
}
