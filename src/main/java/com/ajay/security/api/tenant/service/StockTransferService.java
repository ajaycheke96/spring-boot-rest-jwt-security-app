package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public StockTransfer saveStockTransfer(StockTransfer stockTransfer) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (stockTransfer.getCreatedAt() == null)
			stockTransfer.setCreatedAt(currentTimestamp);
		stockTransfer.setUpdatedAt(currentTimestamp);

		// For stockTransferDetails list
		if (!stockTransfer.getStockTransferDetails().isEmpty())
			stockTransfer.getStockTransferDetails().forEach(stockTransferDetail -> {
				if (stockTransferDetail.getCreatedAt() == null)
					stockTransferDetail.setCreatedAt(currentTimestamp);
				stockTransferDetail.setUpdatedAt(currentTimestamp);
			});

		return stockTransferRepository.save(stockTransfer);
	}

	public String deleteOneStockTransfer(StockTransfer stockTransfer) {
		String result = null;
		if (stockTransferRepository.existsById(stockTransfer.getId())) {
			stockTransferRepository.delete(stockTransfer);
			result = " StockTransfer deleted!";
		} else {
			result = "StockTransfer Not Found! or Already deleted!";
		}
		return result;
	}
}
