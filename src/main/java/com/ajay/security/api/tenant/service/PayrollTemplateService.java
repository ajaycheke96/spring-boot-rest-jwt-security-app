package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public PayrollTemplate savePayrollTemplate(PayrollTemplate payrollTemplate) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (payrollTemplate.getCreatedAt() == null)
			payrollTemplate.setCreatedAt(currentTimestamp);
		payrollTemplate.setUpdatedAt(currentTimestamp);

		// For PayrollTemplateDetails list
		if (!payrollTemplate.getPayrollTemplateDetails().isEmpty())
			payrollTemplate.getPayrollTemplateDetails().forEach(payrollTemplateDetail -> {
				if (payrollTemplateDetail.getCreatedAt() == null)
					payrollTemplateDetail.setCreatedAt(currentTimestamp);
				payrollTemplateDetail.setUpdatedAt(currentTimestamp);
			});
		return payrollTemplateRepository.save(payrollTemplate);
	}

	public String deleteOnePayrollTemplate(PayrollTemplate payrollTemplate) {
		String result = null;
		if (payrollTemplateRepository.existsById(payrollTemplate.getId())) {
			payrollTemplateRepository.delete(payrollTemplate);
			result = "PayrollTemplate deleted!";
		} else {
			result = "PayrollTemplate not found! Or Already deleted!";
		}
		return result;
	}
}
