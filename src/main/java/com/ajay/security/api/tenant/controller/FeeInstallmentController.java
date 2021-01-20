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

import com.ajay.security.api.tenant.entity.FeeInstallment;
import com.ajay.security.api.tenant.service.FeeInstallmentService;

@RestController
@RequestMapping("/feeInstallment")
public class FeeInstallmentController {

	@Autowired
	private FeeInstallmentService feeInstallmentService;

	@GetMapping("/all")
	public List<FeeInstallment> getAllFeeInstallment() {
		return feeInstallmentService.getAllFeeInstallments();
	}

	@GetMapping("/one/{id}")
	public FeeInstallment getOneFeeInstallment(@PathVariable Integer id) {
		return feeInstallmentService.getOneFeeInstallment(id);
	}

	@PostMapping("/save")
	public String saveFeeInstallment(@RequestBody FeeInstallment feeInstallment) {
		return feeInstallmentService.saveFeeInstallment(feeInstallment);
	}

	@PutMapping("/update")
	public String updateFeeInstallment(@RequestBody FeeInstallment feeInstallment) {
		return feeInstallmentService.updateFeeInstallment(feeInstallment);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFeeInstallment(@PathVariable Integer id) {
		return feeInstallmentService.deleteOneFeeInstallment(id);
	}
}
