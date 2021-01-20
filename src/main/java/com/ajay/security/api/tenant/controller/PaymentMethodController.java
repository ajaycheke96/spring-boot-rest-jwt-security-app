package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.PaymentMethod;
import com.ajay.security.api.tenant.service.PaymentMethodService;

@RestController
@RequestMapping("/paymentMethod")
public class PaymentMethodController {

	@Autowired
	private PaymentMethodService paymentMethodService;

	@GetMapping("/all")
	public List<PaymentMethod> getAllPaymentMethod() {
		return paymentMethodService.getAllPaymentMethods();
	}

	@GetMapping("/one/{id}")
	public PaymentMethod getOnePaymentMethod(@PathVariable Integer id) {
		return paymentMethodService.getOnePaymentMethod(id);
	}

	@PostMapping("/save")
	public String savePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
		return paymentMethodService.savePaymentMethod(paymentMethod);
	}

	@PutMapping("/update")
	public String updatePaymentMethod(@RequestBody PaymentMethod paymentMethod) {
		return paymentMethodService.updatePaymentMethod(paymentMethod);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOnePaymentMethod(@PathVariable Integer id) {
		return paymentMethodService.deleteOnePaymentMethod(id);
	}
}
