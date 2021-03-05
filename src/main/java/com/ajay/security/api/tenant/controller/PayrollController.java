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

import com.ajay.security.api.tenant.entity.Payroll;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.PayrollService;

@RestController
@RequestMapping("/payroll")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PayrollController {

	@Autowired
	private PayrollService payrollService;

	@GetMapping("/listAllPayroll")
	public ApiResponse getAllPayroll() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Payroll", payrollService.getAllPayrolls());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Payroll Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOnePayroll(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Payroll", payrollService.getOnePayroll(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Payroll Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/savePayroll")
	public ApiResponse savePayroll(@RequestBody Payroll payroll) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Payroll saved!",
					payrollService.savePayroll(payroll));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Payroll Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updatePayroll")
	public ApiResponse updatePayroll(@RequestBody Payroll payroll) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Payroll updated!",
					payrollService.savePayroll(payroll));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Payroll Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deletePayroll")
	public ApiResponse deleteOnePayroll(@RequestBody Payroll payroll) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, payrollService.deleteOnePayroll(payroll), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Payroll Service exception : " + e.getLocalizedMessage());
		}
	}
}
