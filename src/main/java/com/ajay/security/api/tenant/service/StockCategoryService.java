package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StockCategory;
import com.ajay.security.api.tenant.repository.StockCategoryRepository;

@Service
@Transactional
public class StockCategoryService {

	@Autowired
	private StockCategoryRepository stockCategoryRepository;

	public List<StockCategory> getAllStockCategorys() {
		return stockCategoryRepository.findAll();
	}

	public StockCategory getOneStockCategory(Integer id) {
		return stockCategoryRepository.findById(id).get();
	}

	public String saveStockCategory(StockCategory stockCategory) {
		return stockCategoryRepository.save(stockCategory) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStockCategory(StockCategory stockCategory) {
		return stockCategoryRepository.save(stockCategory) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStockCategory(Integer id) {
		stockCategoryRepository.deleteById(id);
		return " successfully deleted!";
	}
}
