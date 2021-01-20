package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.StockTransferDetail;
import com.ajay.security.api.tenant.repository.StockTransferDetailRepository;

@Service
@Transactional
public class StockTransferDetailService {

	@Autowired
	private StockTransferDetailRepository stockTransferDetailRepository;

	public List<StockTransferDetail> getAllStockTransferDetails() {
		return stockTransferDetailRepository.findAll();
	}

	public StockTransferDetail getOneStockTransferDetail(Integer id) {
		return stockTransferDetailRepository.findById(id).get();
	}

	public String saveStockTransferDetail(StockTransferDetail stockTransferDetail) {
		return stockTransferDetailRepository.save(stockTransferDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateStockTransferDetail(StockTransferDetail stockTransferDetail) {
		return stockTransferDetailRepository.save(stockTransferDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneStockTransferDetail(Integer id) {
		stockTransferDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
