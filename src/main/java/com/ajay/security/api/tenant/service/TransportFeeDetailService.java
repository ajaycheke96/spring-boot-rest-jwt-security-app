package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TransportFeeDetail;
import com.ajay.security.api.tenant.repository.TransportFeeDetailRepository;

@Service
@Transactional
public class TransportFeeDetailService {

	@Autowired
	private TransportFeeDetailRepository transportFeeDetailRepository;

	public List<TransportFeeDetail> getAllTransportFeeDetails() {
		return transportFeeDetailRepository.findAll();
	}

	public TransportFeeDetail getOneTransportFeeDetail(Integer id) {
		return transportFeeDetailRepository.findById(id).get();
	}

	public String saveTransportFeeDetail(TransportFeeDetail transportFeeDetail) {
		return transportFeeDetailRepository.save(transportFeeDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTransportFeeDetail(TransportFeeDetail transportFeeDetail) {
		return transportFeeDetailRepository.save(transportFeeDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransportFeeDetail(Integer id) {
		transportFeeDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
