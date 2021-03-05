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

import com.ajay.security.api.tenant.entity.StockItem;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.StockItemService;

@RestController
@RequestMapping("/stockItem")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StockItemController {

	@Autowired
	private StockItemService stockItemService;

	@GetMapping("/listAllStockItem")
	public ApiResponse getAllStockItem() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of StockItem",
					stockItemService.getAllStockItems());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockItem Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneStockItem(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockItem", stockItemService.getOneStockItem(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockItem Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveStockItem")
	public ApiResponse saveStockItem(@RequestBody StockItem stockItem) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockItem saved!",
					stockItemService.saveStockItem(stockItem));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockItem Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateStockItem")
	public ApiResponse updateStockItem(@RequestBody StockItem stockItem) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockItem updated!",
					stockItemService.saveStockItem(stockItem));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockItem Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteStockItem")
	public ApiResponse deleteOneStockItem(@RequestBody StockItem stockItem) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, stockItemService.deleteOneStockItem(stockItem),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockItem Service exception : " + e.getLocalizedMessage());
		}
	}
}
