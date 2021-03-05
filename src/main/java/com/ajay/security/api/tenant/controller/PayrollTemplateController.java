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

import com.ajay.security.api.tenant.entity.PayrollTemplate;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.PayrollTemplateService;

@RestController
@RequestMapping("/payrollTemplate")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PayrollTemplateController {

	@Autowired
	private PayrollTemplateService payrollTemplateService;

	@GetMapping("/listAllPayrollTemplate")
	public ApiResponse getAllPayrollTemplate() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of PayrollTemplate",
					payrollTemplateService.getAllPayrollTemplates());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayrollTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOnePayrollTemplate(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PayrollTemplate",
					payrollTemplateService.getOnePayrollTemplate(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayrollTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/savePayrollTemplate")
	public ApiResponse savePayrollTemplate(@RequestBody PayrollTemplate payrollTemplate) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PayrollTemplate saved!",
					payrollTemplateService.savePayrollTemplate(payrollTemplate));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayrollTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updatePayrollTemplate")
	public ApiResponse updatePayrollTemplate(@RequestBody PayrollTemplate payrollTemplate) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "PayrollTemplate updated!",
					payrollTemplateService.savePayrollTemplate(payrollTemplate));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayrollTemplate Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deletePayrollTemplate")
	public ApiResponse deleteOnePayrollTemplate(@RequestBody PayrollTemplate payrollTemplate) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					payrollTemplateService.deleteOnePayrollTemplate(payrollTemplate), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"PayrollTemplate Service exception : " + e.getLocalizedMessage());
		}
	}
}
