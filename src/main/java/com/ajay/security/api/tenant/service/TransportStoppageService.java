package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TransportStoppage;
import com.ajay.security.api.tenant.repository.TransportStoppageRepository;

@Service
@Transactional
public class TransportStoppageService {

	@Autowired
	private TransportStoppageRepository transportStoppageRepository;

	public List<TransportStoppage> getAllTransportStoppages() {
		return transportStoppageRepository.findAll();
	}

	public TransportStoppage getOneTransportStoppage(Integer id) {
		return transportStoppageRepository.findById(id).get();
	}

	public TransportStoppage saveTransportStoppage(TransportStoppage transportStoppage) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (transportStoppage.getCreatedAt() == null)
			transportStoppage.setCreatedAt(currentTimestamp);
		transportStoppage.setUpdatedAt(currentTimestamp);
		return transportStoppageRepository.save(transportStoppage);
	}

	public String deleteOneTransportStoppage(TransportStoppage transportStoppage) {
		String result = null;
		if (transportStoppageRepository.existsById(transportStoppage.getId())) {
			transportStoppageRepository.delete(transportStoppage);
			result = " TransportStoppage deleted!";
		} else {
			result = "TransportStoppage Not Found! or Already deleted!";
		}
		return result;
	}
}
