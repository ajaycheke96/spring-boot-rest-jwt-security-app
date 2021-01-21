package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TransportRoute;
import com.ajay.security.api.tenant.repository.TransportRouteRepository;

@Service
@Transactional
public class TransportRouteService {

	@Autowired
	private TransportRouteRepository transportRouteRepository;

	public List<TransportRoute> getAllTransportRoutes() {
		return transportRouteRepository.findAll();
	}

	public TransportRoute getOneTransportRoute(Integer id) {
		return transportRouteRepository.findById(id).get();
	}

	public String saveTransportRoute(TransportRoute transportRoute) {
		return transportRouteRepository.save(transportRoute) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTransportRoute(TransportRoute transportRoute) {
		return transportRouteRepository.save(transportRoute) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransportRoute(Integer id) {
		transportRouteRepository.deleteById(id);
		return " successfully deleted!";
	}
}
