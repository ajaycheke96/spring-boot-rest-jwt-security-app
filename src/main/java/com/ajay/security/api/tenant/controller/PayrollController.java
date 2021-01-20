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

import com.ajay.security.api.tenant.entity.Payroll;
import com.ajay.security.api.tenant.service.PayrollService;

@RestController
@RequestMapping("/payroll")
public class PayrollController {

	@Autowired
	private PayrollService payrollService;

	@GetMapping("/all")
	public List<Payroll> getAllPayroll() {
		return payrollService.getAllPayrolls();
	}

	@GetMapping("/one/{id}")
	public Payroll getOnePayroll(@PathVariable Integer id) {
		return payrollService.getOnePayroll(id);
	}

	@PostMapping("/save")
	public String savePayroll(@RequestBody Payroll payroll) {
		return payrollService.savePayroll(payroll);
	}

	@PutMapping("/update")
	public String updatePayroll(@RequestBody Payroll payroll) {
		return payrollService.updatePayroll(payroll);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOnePayroll(@PathVariable Integer id) {
		return payrollService.deleteOnePayroll(id);
	}
}
