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

import com.ajay.security.api.tenant.entity.PayrollTemplateDetail;
import com.ajay.security.api.tenant.service.PayrollTemplateDetailService;

@RestController
@RequestMapping("/payrollTemplateDetail")
public class PayrollTemplateDetailController {

	@Autowired
	private PayrollTemplateDetailService payrollTemplateDetailService;

	@GetMapping("/all")
	public List<PayrollTemplateDetail> getAllPayrollTemplateDetail() {
		return payrollTemplateDetailService.getAllPayrollTemplateDetails();
	}

	@GetMapping("/one/{id}")
	public PayrollTemplateDetail getOnePayrollTemplateDetail(@PathVariable Integer id) {
		return payrollTemplateDetailService.getOnePayrollTemplateDetail(id);
	}

	@PostMapping("/save")
	public String savePayrollTemplateDetail(@RequestBody PayrollTemplateDetail payrollTemplateDetail) {
		return payrollTemplateDetailService.savePayrollTemplateDetail(payrollTemplateDetail);
	}

	@PutMapping("/update")
	public String updatePayrollTemplateDetail(@RequestBody PayrollTemplateDetail payrollTemplateDetail) {
		return payrollTemplateDetailService.updatePayrollTemplateDetail(payrollTemplateDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOnePayrollTemplateDetail(@PathVariable Integer id) {
		return payrollTemplateDetailService.deleteOnePayrollTemplateDetail(id);
	}
}
