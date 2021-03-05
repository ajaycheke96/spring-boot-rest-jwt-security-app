package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public StockItem saveStockItem(StockItem stockItem) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (stockItem.getCreatedAt() == null)
			stockItem.setCreatedAt(currentTimestamp);
		stockItem.setUpdatedAt(currentTimestamp);
		return stockItemRepository.save(stockItem);
	}

	public String deleteOneStockItem(StockItem stockItem) {
		String result = null;
		if (stockItemRepository.existsById(stockItem.getId())) {
			stockItemRepository.delete(stockItem);
			result = " StockItem deleted!";
		} else {
			result = "StockItem Not Found! or Already deleted!";
		}
		return result;
	}
}
