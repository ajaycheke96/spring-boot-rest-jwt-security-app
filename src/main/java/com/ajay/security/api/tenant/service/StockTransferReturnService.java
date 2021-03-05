package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StockTransferReturn;
import com.ajay.security.api.tenant.repository.StockTransferReturnRepository;

@Service
@Transactional
public class StockTransferReturnService {

	@Autowired
	private StockTransferReturnRepository stockTransferReturnRepository;

	public List<StockTransferReturn> getAllStockTransferReturns() {
		return stockTransferReturnRepository.findAll();
	}

	public StockTransferReturn getOneStockTransferReturn(Integer id) {
		return stockTransferReturnRepository.findById(id).get();
	}

	public StockTransferReturn saveStockTransferReturn(StockTransferReturn stockTransferReturn) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (stockTransferReturn.getCreatedAt() == null)
			stockTransferReturn.setCreatedAt(currentTimestamp);
		stockTransferReturn.setUpdatedAt(currentTimestamp);
		return stockTransferReturnRepository.save(stockTransferReturn);
	}

	public String deleteOneStockTransferReturn(StockTransferReturn stockTransferReturn) {
		String result = null;
		if (stockTransferReturnRepository.existsById(stockTransferReturn.getId())) {
			stockTransferReturnRepository.delete(stockTransferReturn);
			result = " StockTransferReturn deleted!";
		} else {
			result = "StockTransferReturn Not Found! or Already deleted!";
		}
		return result;
	}
}
