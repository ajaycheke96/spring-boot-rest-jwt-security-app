package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public TransportRoute saveTransportRoute(TransportRoute transportRoute) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (transportRoute.getCreatedAt() == null)
			transportRoute.setCreatedAt(currentTimestamp);
		transportRoute.setUpdatedAt(currentTimestamp);

		// For transportRouteDetails list
		if (!transportRoute.getTransportRouteDetails().isEmpty())
			transportRoute.getTransportRouteDetails().forEach(transportRouteDetail -> {
				if (transportRouteDetail.getCreatedAt() == null)
					transportRouteDetail.setCreatedAt(currentTimestamp);
				transportRouteDetail.setUpdatedAt(currentTimestamp);
			});
		return transportRouteRepository.save(transportRoute);
	}

	public String deleteOneTransportRoute(TransportRoute transportRoute) {
		String result = null;
		if (transportRouteRepository.existsById(transportRoute.getId())) {
			transportRouteRepository.delete(transportRoute);
			result = " TransportRoute deleted!";
		} else {
			result = "TransportRoute Not Found! or Already deleted!";
		}
		return result;
	}
}
