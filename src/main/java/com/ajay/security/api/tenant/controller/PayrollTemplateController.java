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

import com.ajay.security.api.tenant.entity.PayrollTemplate;
import com.ajay.security.api.tenant.service.PayrollTemplateService;

@RestController
@RequestMapping("/payrollTemplate")
public class PayrollTemplateController {

	@Autowired
	private PayrollTemplateService payrollTemplateService;

	@GetMapping("/all")
	public List<PayrollTemplate> getAllPayrollTemplate() {
		return payrollTemplateService.getAllPayrollTemplates();
	}

	@GetMapping("/one/{id}")
	public PayrollTemplate getOnePayrollTemplate(@PathVariable Integer id) {
		return payrollTemplateService.getOnePayrollTemplate(id);
	}

	@PostMapping("/save")
	public String savePayrollTemplate(@RequestBody PayrollTemplate payrollTemplate) {
		return payrollTemplateService.savePayrollTemplate(payrollTemplate);
	}

	@PutMapping("/update")
	public String updatePayrollTemplate(@RequestBody PayrollTemplate payrollTemplate) {
		return payrollTemplateService.updatePayrollTemplate(payrollTemplate);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOnePayrollTemplate(@PathVariable Integer id) {
		return payrollTemplateService.deleteOnePayrollTemplate(id);
	}
}
