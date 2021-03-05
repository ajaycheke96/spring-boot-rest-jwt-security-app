package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TransportFee;
import com.ajay.security.api.tenant.repository.TransportFeeRepository;

@Service
@Transactional
public class TransportFeeService {

	@Autowired
	private TransportFeeRepository transportFeeRepository;

	public List<TransportFee> getAllTransportFees() {
		return transportFeeRepository.findAll();
	}

	public TransportFee getOneTransportFee(Integer id) {
		return transportFeeRepository.findById(id).get();
	}

	public TransportFee saveTransportFee(TransportFee transportFee) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (transportFee.getCreatedAt() == null)
			transportFee.setCreatedAt(currentTimestamp);
		transportFee.setUpdatedAt(currentTimestamp);

		// For transportFeeDetails list
		if (!transportFee.getTransportFeeDetails().isEmpty())
			transportFee.getTransportFeeDetails().forEach(transportFeeDetail -> {
				if (transportFeeDetail.getCreatedAt() == null)
					transportFeeDetail.setCreatedAt(currentTimestamp);
				transportFeeDetail.setUpdatedAt(currentTimestamp);
			});
		return transportFeeRepository.save(transportFee);
	}

	public String deleteOneTransportFee(TransportFee transportFee) {
		String result = null;
		if (transportFeeRepository.existsById(transportFee.getId())) {
			transportFeeRepository.delete(transportFee);
			result = " TransportFee deleted!";
		} else {
			result = "TransportFee Not Found! or Already deleted!";
		}
		return result;
	}
}
