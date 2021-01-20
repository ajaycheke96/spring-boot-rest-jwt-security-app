package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.PayrollTemplate;
import com.ajay.security.api.tenant.repository.PayrollTemplateRepository;

@Service
@Transactional
public class PayrollTemplateService {

	@Autowired
	private PayrollTemplateRepository payrollTemplateRepository;

	public List<PayrollTemplate> getAllPayrollTemplates() {
		return payrollTemplateRepository.findAll();
	}

	public PayrollTemplate getOnePayrollTemplate(Integer id) {
		return payrollTemplateRepository.findById(id).get();
	}

	public String savePayrollTemplate(PayrollTemplate payrollTemplate) {
		return payrollTemplateRepository.save(payrollTemplate) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updatePayrollTemplate(PayrollTemplate payrollTemplate) {
		return payrollTemplateRepository.save(payrollTemplate) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOnePayrollTemplate(Integer id) {
		payrollTemplateRepository.deleteById(id);
		return " successfully deleted!";
	}
}
