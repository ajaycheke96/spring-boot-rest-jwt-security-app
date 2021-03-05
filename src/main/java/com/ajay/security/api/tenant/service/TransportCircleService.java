package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public TransportCircle saveTransportCircle(TransportCircle transportCircle) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (transportCircle.getCreatedAt() == null)
			transportCircle.setCreatedAt(currentTimestamp);
		transportCircle.setUpdatedAt(currentTimestamp);
		return transportCircleRepository.save(transportCircle);
	}

	public String deleteOneTransportCircle(TransportCircle transportCircle) {
		String result = null;
		if (transportCircleRepository.existsById(transportCircle.getId())) {
			transportCircleRepository.delete(transportCircle);
			result = " TransportCircle deleted!";
		} else {
			result = "TransportCircle Not Found! or Already deleted!";
		}
		return result;
	}
}
