package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.PayrollDetail;
import com.ajay.security.api.tenant.repository.PayrollDetailRepository;

@Service
@Transactional
public class PayrollDetailService {

	@Autowired
	private PayrollDetailRepository payrollDetailRepository;

	public List<PayrollDetail> getAllPayrollDetails() {
		return payrollDetailRepository.findAll();
	}

	public PayrollDetail getOnePayrollDetail(Integer id) {
		return payrollDetailRepository.findById(id).get();
	}

	public String savePayrollDetail(PayrollDetail payrollDetail) {
		return payrollDetailRepository.save(payrollDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updatePayrollDetail(PayrollDetail payrollDetail) {
		return payrollDetailRepository.save(payrollDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOnePayrollDetail(Integer id) {
		payrollDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
