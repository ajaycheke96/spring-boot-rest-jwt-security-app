package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.StockTransfer;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.StockTransferService;

@RestController
@RequestMapping("/stockTransfer")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StockTransferController {

	@Autowired
	private StockTransferService stockTransferService;

	@GetMapping("/listAllStockTransfer")
	public ApiResponse getAllStockTransfer() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of StockTransfer",
					stockTransferService.getAllStockTransfers());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransfer Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneStockTransfer(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockTransfer",
					stockTransferService.getOneStockTransfer(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransfer Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveStockTransfer")
	public ApiResponse saveStockTransfer(@RequestBody StockTransfer stockTransfer) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockTransfer saved!",
					stockTransferService.saveStockTransfer(stockTransfer));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransfer Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateStockTransfer")
	public ApiResponse updateStockTransfer(@RequestBody StockTransfer stockTransfer) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockTransfer updated!",
					stockTransferService.saveStockTransfer(stockTransfer));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransfer Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteStockTransfer")
	public ApiResponse deleteOneStockTransfer(@RequestBody StockTransfer stockTransfer) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					stockTransferService.deleteOneStockTransfer(stockTransfer), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransfer Service exception : " + e.getLocalizedMessage());
		}
	}
}
