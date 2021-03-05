package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public StockPurchase saveStockPurchase(StockPurchase stockPurchase) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (stockPurchase.getCreatedAt() == null)
			stockPurchase.setCreatedAt(currentTimestamp);
		stockPurchase.setUpdatedAt(currentTimestamp);

		// For StockPurchaseDetails list
		if (!stockPurchase.getStockPurchaseDetails().isEmpty())
			stockPurchase.getStockPurchaseDetails().forEach(stockPurchaseDetail -> {
				if (stockPurchaseDetail.getCreatedAt() == null)
					stockPurchaseDetail.setCreatedAt(currentTimestamp);
				stockPurchaseDetail.setUpdatedAt(currentTimestamp);
			});
		return stockPurchaseRepository.save(stockPurchase);
	}

	public String deleteOneStockPurchase(StockPurchase stockPurchase) {
		String result = null;
		if (stockPurchaseRepository.existsById(stockPurchase.getId())) {
			stockPurchaseRepository.delete(stockPurchase);
			result = " StockPurchase deleted!";
		} else {
			result = "StockPurchase Not Found! or Already deleted!";
		}
		return result;
	}
}
