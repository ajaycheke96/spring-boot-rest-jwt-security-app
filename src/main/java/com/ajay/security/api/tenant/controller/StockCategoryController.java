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

import com.ajay.security.api.tenant.entity.StockCategory;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.StockCategoryService;

@RestController
@RequestMapping("/stockCategory")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StockCategoryController {

	@Autowired
	private StockCategoryService stockCategoryService;

	@GetMapping("/listAllStockCategory")
	public ApiResponse getAllStockCategory() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of StockCategory",
					stockCategoryService.getAllStockCategorys());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneStockCategory(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockCategory",
					stockCategoryService.getOneStockCategory(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveStockCategory")
	public ApiResponse saveStockCategory(@RequestBody StockCategory stockCategory) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockCategory saved!",
					stockCategoryService.saveStockCategory(stockCategory));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateStockCategory")
	public ApiResponse updateStockCategory(@RequestBody StockCategory stockCategory) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "StockCategory updated!",
					stockCategoryService.saveStockCategory(stockCategory));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockCategory Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteStockCategory")
	public ApiResponse deleteOneStockCategory(@RequestBody StockCategory stockCategory) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					stockCategoryService.deleteOneStockCategory(stockCategory), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"StockCategory Service exception : " + e.getLocalizedMessage());
		}
	}
}
