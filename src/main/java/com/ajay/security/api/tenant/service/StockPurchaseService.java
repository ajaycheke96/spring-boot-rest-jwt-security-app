package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StockPurchase;
import com.ajay.security.api.tenant.repository.StockPurchaseRepository;

@Service
@Transactional
public class StockPurchaseService {

	@Autowired
	private StockPurchaseRepository stockPurchaseRepository;

	public List<StockPurchase> getAllStockPurchases() {
		return stockPurchaseRepository.findAll();
	}

	public StockPurchase getOneStockPurchase(Integer id) {
		return stockPurchaseRepository.findById(id).get();
	}

	public String saveStockPurchase(StockPurchase stockPurchase) {
		return stockPurchaseRepository.save(stockPurchase) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStockPurchase(StockPurchase stockPurchase) {
		return stockPurchaseRepository.save(stockPurchase) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStockPurchase(Integer id) {
		stockPurchaseRepository.deleteById(id);
		return " successfully deleted!";
	}
}
