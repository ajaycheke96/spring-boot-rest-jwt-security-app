package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.PayrollTemplateDetail;
import com.ajay.security.api.tenant.repository.PayrollTemplateDetailRepository;

@Service
@Transactional
public class PayrollTemplateDetailService {

	@Autowired
	private PayrollTemplateDetailRepository payrollTemplateDetailRepository;

	public List<PayrollTemplateDetail> getAllPayrollTemplateDetails() {
		return payrollTemplateDetailRepository.findAll();
	}

	public PayrollTemplateDetail getOnePayrollTemplateDetail(Integer id) {
		return payrollTemplateDetailRepository.findById(id).get();
	}

	public String savePayrollTemplateDetail(PayrollTemplateDetail payrollTemplateDetail) {
		return payrollTemplateDetailRepository.save(payrollTemplateDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updatePayrollTemplateDetail(PayrollTemplateDetail payrollTemplateDetail) {
		return payrollTemplateDetailRepository.save(payrollTemplateDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOnePayrollTemplateDetail(Integer id) {
		payrollTemplateDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
