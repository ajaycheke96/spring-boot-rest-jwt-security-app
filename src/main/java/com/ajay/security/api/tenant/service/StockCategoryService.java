package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public StockCategory saveStockCategory(StockCategory stockCategory) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (stockCategory.getCreatedAt() == null)
			stockCategory.setCreatedAt(currentTimestamp);
		stockCategory.setUpdatedAt(currentTimestamp);
		return stockCategoryRepository.save(stockCategory);
	}

	public String deleteOneStockCategory(StockCategory stockCategory) {
		String result = null;
		if (stockCategoryRepository.existsById(stockCategory.getId())) {
			stockCategoryRepository.delete(stockCategory);
			result = " StockCategory deleted!";
		} else {
			result = "StockCategory Not Found! or Already deleted!";
		}
		return result;
	}
}
