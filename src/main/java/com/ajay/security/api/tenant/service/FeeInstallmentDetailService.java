package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeInstallmentDetail;
import com.ajay.security.api.tenant.repository.FeeInstallmentDetailRepository;

@Service
@Transactional
public class FeeInstallmentDetailService {

	@Autowired
	private FeeInstallmentDetailRepository feeInstallmentDetailRepository;

	public List<FeeInstallmentDetail> getAllFeeInstallmentDetails() {
		return feeInstallmentDetailRepository.findAll();
	}

	public FeeInstallmentDetail getOneFeeInstallmentDetail(Integer id) {
		return feeInstallmentDetailRepository.findById(id).get();
	}

	public String saveFeeInstallmentDetail(FeeInstallmentDetail feeInstallmentDetail) {
		return feeInstallmentDetailRepository.save(feeInstallmentDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateFeeInstallmentDetail(FeeInstallmentDetail feeInstallmentDetail) {
		return feeInstallmentDetailRepository.save(feeInstallmentDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneFeeInstallmentDetail(Integer id) {
		feeInstallmentDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
