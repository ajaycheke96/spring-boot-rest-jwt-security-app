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

import com.ajay.security.api.tenant.entity.PayrollDetail;
import com.ajay.security.api.tenant.service.PayrollDetailService;

@RestController
@RequestMapping("/payrollDetail")
public class PayrollDetailController {

	@Autowired
	private PayrollDetailService payrollDetailService;

	@GetMapping("/all")
	public List<PayrollDetail> getAllPayrollDetail() {
		return payrollDetailService.getAllPayrollDetails();
	}

	@GetMapping("/one/{id}")
	public PayrollDetail getOnePayrollDetail(@PathVariable Integer id) {
		return payrollDetailService.getOnePayrollDetail(id);
	}

	@PostMapping("/save")
	public String savePayrollDetail(@RequestBody PayrollDetail payrollDetail) {
		return payrollDetailService.savePayrollDetail(payrollDetail);
	}

	@PutMapping("/update")
	public String updatePayrollDetail(@RequestBody PayrollDetail payrollDetail) {
		return payrollDetailService.updatePayrollDetail(payrollDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOnePayrollDetail(@PathVariable Integer id) {
		return payrollDetailService.deleteOnePayrollDetail(id);
	}
}
