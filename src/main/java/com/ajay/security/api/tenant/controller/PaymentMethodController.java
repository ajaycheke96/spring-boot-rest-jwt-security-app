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

import com.ajay.security.api.tenant.entity.PaymentMethod;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.PaymentMethodService;

@RestController
@RequestMapping("/paymentMethod")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PaymentMethodController {

	@Autowired
	private PaymentMethodService paymentMethodService;

	@GetMapping("/listAllPaymentMethod")
	public ApiResponse getAllPaymentMethod() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of PaymentMethod",
					paymentMethodService.getAllPaymentMethods());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PaymentMethod Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOnePaymentMethod(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PaymentMethod",
					paymentMethodService.getOnePaymentMethod(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PaymentMethod Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/savePaymentMethod")
	public ApiResponse savePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PaymentMethod saved!",
					paymentMethodService.savePaymentMethod(paymentMethod));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PaymentMethod Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updatePaymentMethod")
	public ApiResponse updatePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PaymentMethod updated!",
					paymentMethodService.savePaymentMethod(paymentMethod));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PaymentMethod Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deletePaymentMethod")
	public ApiResponse deleteOnePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					paymentMethodService.deleteOnePaymentMethod(paymentMethod), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PaymentMethod Service exception : " + e.getLocalizedMessage());
		}
	}
}
