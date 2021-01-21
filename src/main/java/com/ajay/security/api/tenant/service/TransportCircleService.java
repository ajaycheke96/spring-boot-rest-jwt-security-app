package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TransportCircle;
import com.ajay.security.api.tenant.repository.TransportCircleRepository;

@Service
@Transactional
public class TransportCircleService {

	@Autowired
	private TransportCircleRepository transportCircleRepository;

	public List<TransportCircle> getAllTransportCircles() {
		return transportCircleRepository.findAll();
	}

	public TransportCircle getOneTransportCircle(Integer id) {
		return transportCircleRepository.findById(id).get();
	}

	public String saveTransportCircle(TransportCircle transportCircle) {
		return transportCircleRepository.save(transportCircle) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTransportCircle(TransportCircle transportCircle) {
		return transportCircleRepository.save(transportCircle) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransportCircle(Integer id) {
		transportCircleRepository.deleteById(id);
		return " successfully deleted!";
	}
}
