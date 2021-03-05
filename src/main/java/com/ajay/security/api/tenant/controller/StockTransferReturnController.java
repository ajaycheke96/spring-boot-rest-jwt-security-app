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

import com.ajay.security.api.tenant.entity.StockTransferReturn;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.StockTransferReturnService;

@RestController
@RequestMapping("/stockTransferReturn")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StockTransferReturnController {

	@Autowired
	private StockTransferReturnService stockTransferReturnService;

	@GetMapping("/listAllStockTransferReturn")
	public ApiResponse getAllStockTransferReturn() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of StockTransferReturn",
					stockTransferReturnService.getAllStockTransferReturns());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransferReturn Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneStockTransferReturn(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockTransferReturn",
					stockTransferReturnService.getOneStockTransferReturn(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransferReturn Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveStockTransferReturn")
	public ApiResponse saveStockTransferReturn(@RequestBody StockTransferReturn stockTransferReturn) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockTransferReturn saved!",
					stockTransferReturnService.saveStockTransferReturn(stockTransferReturn));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransferReturn Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateStockTransferReturn")
	public ApiResponse updateStockTransferReturn(@RequestBody StockTransferReturn stockTransferReturn) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockTransferReturn updated!",
					stockTransferReturnService.saveStockTransferReturn(stockTransferReturn));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransferReturn Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteStockTransferReturn")
	public ApiResponse deleteOneStockTransferReturn(@RequestBody StockTransferReturn stockTransferReturn) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					stockTransferReturnService.deleteOneStockTransferReturn(stockTransferReturn), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockTransferReturn Service exception : " + e.getLocalizedMessage());
		}
	}
}
