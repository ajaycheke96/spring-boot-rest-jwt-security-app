package com.ajay.security.api.tenant.service;

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

	public String saveTransportStoppage(TransportStoppage transportStoppage) {
		return transportStoppageRepository.save(transportStoppage) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTransportStoppage(TransportStoppage transportStoppage) {
		return transportStoppageRepository.save(transportStoppage) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransportStoppage(Integer id) {
		transportStoppageRepository.deleteById(id);
		return " successfully deleted!";
	}
}
