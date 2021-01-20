package com.ajay.security.api.tenant.service;

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

	public String saveStockTransferReturn(StockTransferReturn stockTransferReturn) {
		return stockTransferReturnRepository.save(stockTransferReturn) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStockTransferReturn(StockTransferReturn stockTransferReturn) {
		return stockTransferReturnRepository.save(stockTransferReturn) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStockTransferReturn(Integer id) {
		stockTransferReturnRepository.deleteById(id);
		return " successfully deleted!";
	}
}
