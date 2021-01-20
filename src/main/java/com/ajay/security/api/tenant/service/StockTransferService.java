package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StockTransfer;
import com.ajay.security.api.tenant.repository.StockTransferRepository;

@Service
@Transactional
public class StockTransferService {

	@Autowired
	private StockTransferRepository stockTransferRepository;

	public List<StockTransfer> getAllStockTransfers() {
		return stockTransferRepository.findAll();
	}

	public StockTransfer getOneStockTransfer(Integer id) {
		return stockTransferRepository.findById(id).get();
	}

	public String saveStockTransfer(StockTransfer stockTransfer) {
		return stockTransferRepository.save(stockTransfer) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStockTransfer(StockTransfer stockTransfer) {
		return stockTransferRepository.save(stockTransfer) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStockTransfer(Integer id) {
		stockTransferRepository.deleteById(id);
		return " successfully deleted!";
	}
}
