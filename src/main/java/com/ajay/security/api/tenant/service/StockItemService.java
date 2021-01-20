package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StockItem;
import com.ajay.security.api.tenant.repository.StockItemRepository;

@Service
@Transactional
public class StockItemService {

	@Autowired
	private StockItemRepository stockItemRepository;

	public List<StockItem> getAllStockItems() {
		return stockItemRepository.findAll();
	}

	public StockItem getOneStockItem(Integer id) {
		return stockItemRepository.findById(id).get();
	}

	public String saveStockItem(StockItem stockItem) {
		return stockItemRepository.save(stockItem) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateStockItem(StockItem stockItem) {
		return stockItemRepository.save(stockItem) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneStockItem(Integer id) {
		stockItemRepository.deleteById(id);
		return " successfully deleted!";
	}
}
