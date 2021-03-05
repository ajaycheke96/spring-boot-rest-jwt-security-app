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

import com.ajay.security.api.tenant.entity.StockPurchase;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.StockPurchaseService;

@RestController
@RequestMapping("/stockPurchase")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StockPurchaseController {

	@Autowired
	private StockPurchaseService stockPurchaseService;

	@GetMapping("/listAllStockPurchase")
	public ApiResponse getAllStockPurchase() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of StockPurchase",
					stockPurchaseService.getAllStockPurchases());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockPurchase Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneStockPurchase(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockPurchase",
					stockPurchaseService.getOneStockPurchase(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockPurchase Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveStockPurchase")
	public ApiResponse saveStockPurchase(@RequestBody StockPurchase stockPurchase) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockPurchase saved!",
					stockPurchaseService.saveStockPurchase(stockPurchase));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockPurchase Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateStockPurchase")
	public ApiResponse updateStockPurchase(@RequestBody StockPurchase stockPurchase) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockPurchase updated!",
					stockPurchaseService.saveStockPurchase(stockPurchase));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockPurchase Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteStockPurchase")
	public ApiResponse deleteOneStockPurchase(@RequestBody StockPurchase stockPurchase) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					stockPurchaseService.deleteOneStockPurchase(stockPurchase), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockPurchase Service exception : " + e.getLocalizedMessage());
		}
	}
}
