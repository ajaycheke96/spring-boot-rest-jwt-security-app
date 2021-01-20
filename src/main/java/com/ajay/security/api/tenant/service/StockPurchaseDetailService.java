package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StockPurchaseDetail;
import com.ajay.security.api.tenant.repository.StockPurchaseDetailRepository;

@Service
@Transactional
public class StockPurchaseDetailService {

	@Autowired
	private StockPurchaseDetailRepository stockPurchaseDetailRepository;

	public List<StockPurchaseDetail> getAllStockPurchaseDetails() {
		return stockPurchaseDetailRepository.findAll();
	}

	public StockPurchaseDetail getOneStockPurchaseDetail(Integer id) {
		return stockPurchaseDetailRepository.findById(id).get();
	}

	public String saveStockPurchaseDetail(StockPurchaseDetail stockPurchaseDetail) {
		return stockPurchaseDetailRepository.save(stockPurchaseDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStockPurchaseDetail(StockPurchaseDetail stockPurchaseDetail) {
		return stockPurchaseDetailRepository.save(stockPurchaseDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStockPurchaseDetail(Integer id) {
		stockPurchaseDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
