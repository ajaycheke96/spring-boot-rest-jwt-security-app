package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public Payroll savePayroll(Payroll payroll) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

		if (payroll.getCreatedAt() == null)
			payroll.setCreatedAt(currentTimestamp);
		payroll.setUpdatedAt(currentTimestamp);

		// For payrollDetails list
		if (!payroll.getPayrollDetails().isEmpty())
			payroll.getPayrollDetails().forEach(payrollDetail -> {
				if (payrollDetail.getCreatedAt() == null)
					payrollDetail.setCreatedAt(currentTimestamp);
				payrollDetail.setUpdatedAt(currentTimestamp);
			});

		// For Transactions list
		if (!payroll.getTransactions().isEmpty())
			payroll.getTransactions().forEach(transaction -> {
				if (transaction.getCreatedAt() == null)
					transaction.setCreatedAt(currentTimestamp);
				transaction.setUpdatedAt(currentTimestamp);
			});
		return payrollRepository.save(payroll);
	}

	public String deleteOnePayroll(Payroll payroll) {
		String result = null;
		if (payrollRepository.existsById(payroll.getId())) {
			payrollRepository.delete(payroll);
			result = "Payroll deleted!";
		} else {
			result = "Payroll not found! Or Already deleted!";
		}
		return result;
	}
}
