package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Payroll;
import com.ajay.security.api.tenant.repository.PayrollRepository;

@Service
@Transactional
public class PayrollService {

	@Autowired
	private PayrollRepository payrollRepository;

	public List<Payroll> getAllPayrolls() {
		return payrollRepository.findAll();
	}

	public Payroll getOnePayroll(Integer id) {
		return payrollRepository.findById(id).get();
	}

	public String savePayroll(Payroll payroll) {
		return payrollRepository.save(payroll) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updatePayroll(Payroll payroll) {
		return payrollRepository.save(payroll) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOnePayroll(Integer id) {
		payrollRepository.deleteById(id);
		return " successfully deleted!";
	}
}
