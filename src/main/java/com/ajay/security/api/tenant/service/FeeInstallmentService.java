package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeInstallment;
import com.ajay.security.api.tenant.repository.FeeInstallmentRepository;

@Service
@Transactional
public class FeeInstallmentService {

	@Autowired
	private FeeInstallmentRepository feeInstallmentRepository;

	public List<FeeInstallment> getAllFeeInstallments() {
		return feeInstallmentRepository.findAll();
	}

	public FeeInstallment getOneFeeInstallment(Integer id) {
		return feeInstallmentRepository.findById(id).get();
	}

	public String saveFeeInstallment(FeeInstallment feeInstallment) {
		return feeInstallmentRepository.save(feeInstallment) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateFeeInstallment(FeeInstallment feeInstallment) {
		return feeInstallmentRepository.save(feeInstallment) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneFeeInstallment(Integer id) {
		feeInstallmentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
