package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public FeeInstallment saveFeeInstallment(FeeInstallment feeInstallment) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (feeInstallment.getCreatedAt() == null)
			feeInstallment.setCreatedAt(currentTimestamp);
		feeInstallment.setUpdatedAt(currentTimestamp);

		if (!feeInstallment.getFeeInstallmentDetails().isEmpty())
			feeInstallment.getFeeInstallmentDetails().forEach(feeInstallmentDetail -> {
				if (feeInstallmentDetail.getCreatedAt() == null)
					feeInstallmentDetail.setCreatedAt(currentTimestamp);
				feeInstallmentDetail.setUpdatedAt(currentTimestamp);
			});
		return feeInstallmentRepository.save(feeInstallment);
	}

	public String deleteOneFeeInstallment(FeeInstallment feeInstallment) {
		String result = null;
		if (feeInstallmentRepository.existsById(feeInstallment.getId())) {
			feeInstallmentRepository.delete(feeInstallment);
			result = " FeeInstallment deleted!";
		} else {
			result = "FeeInstallment Not Found! or Already deleted!";
		}
		return result;
	}
}
