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

import com.ajay.security.api.tenant.entity.StockCategory;
import com.ajay.security.api.tenant.service.StockCategoryService;

@RestController
@RequestMapping("/stockCategory")
public class StockCategoryController {

	@Autowired
	private StockCategoryService stockCategoryService;

	@GetMapping("/all")
	public List<StockCategory> getAllStockCategory() {
		return stockCategoryService.getAllStockCategorys();
	}

	@GetMapping("/one/{id}")
	public StockCategory getOneStockCategory(@PathVariable Integer id) {
		return stockCategoryService.getOneStockCategory(id);
	}

	@PostMapping("/save")
	public String saveStockCategory(@RequestBody StockCategory stockCategory) {
		return stockCategoryService.saveStockCategory(stockCategory);
	}

	@PutMapping("/update")
	public String updateStockCategory(@RequestBody StockCategory stockCategory) {
		return stockCategoryService.updateStockCategory(stockCategory);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneStockCategory(@PathVariable Integer id) {
		return stockCategoryService.deleteOneStockCategory(id);
	}
}
