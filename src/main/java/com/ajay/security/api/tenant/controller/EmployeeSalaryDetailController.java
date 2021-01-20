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

import com.ajay.security.api.tenant.entity.EmployeeSalaryDetail;
import com.ajay.security.api.tenant.service.EmployeeSalaryDetailService;

@RestController
@RequestMapping("/employeeSalaryDetail")
public class EmployeeSalaryDetailController {

	@Autowired
	private EmployeeSalaryDetailService employeeSalaryDetailService;

	@GetMapping("/all")
	public List<EmployeeSalaryDetail> getAllEmployeeSalaryDetail() {
		return employeeSalaryDetailService.getAllEmployeeSalaryDetails();
	}

	@GetMapping("/one/{id}")
	public EmployeeSalaryDetail getOneEmployeeSalaryDetail(@PathVariable Integer id) {
		return employeeSalaryDetailService.getOneEmployeeSalaryDetail(id);
	}

	@PostMapping("/save")
	public String saveEmployeeSalaryDetail(@RequestBody EmployeeSalaryDetail employeeSalaryDetail) {
		return employeeSalaryDetailService.saveEmployeeSalaryDetail(employeeSalaryDetail);
	}

	@PutMapping("/update")
	public String updateEmployeeSalaryDetail(@RequestBody EmployeeSalaryDetail employeeSalaryDetail) {
		return employeeSalaryDetailService.updateEmployeeSalaryDetail(employeeSalaryDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneEmployeeSalaryDetail(@PathVariable Integer id) {
		return employeeSalaryDetailService.deleteOneEmployeeSalaryDetail(id);
	}
}
