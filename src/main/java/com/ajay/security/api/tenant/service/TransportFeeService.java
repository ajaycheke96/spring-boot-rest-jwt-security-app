package com.ajay.security.api.tenant.service;

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

	public String saveTransportFee(TransportFee transportFee) {
		return transportFeeRepository.save(transportFee) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTransportFee(TransportFee transportFee) {
		return transportFeeRepository.save(transportFee) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransportFee(Integer id) {
		transportFeeRepository.deleteById(id);
		return " successfully deleted!";
	}
}
