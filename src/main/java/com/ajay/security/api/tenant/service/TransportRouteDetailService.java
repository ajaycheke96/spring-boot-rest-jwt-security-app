package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TransportRouteDetail;
import com.ajay.security.api.tenant.repository.TransportRouteDetailRepository;

@Service
@Transactional
public class TransportRouteDetailService {

	@Autowired
	private TransportRouteDetailRepository transportRouteDetailRepository;

	public List<TransportRouteDetail> getAllTransportRouteDetails() {
		return transportRouteDetailRepository.findAll();
	}

	public TransportRouteDetail getOneTransportRouteDetail(Integer id) {
		return transportRouteDetailRepository.findById(id).get();
	}

	public String saveTransportRouteDetail(TransportRouteDetail transportRouteDetail) {
		return transportRouteDetailRepository.save(transportRouteDetail) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTransportRouteDetail(TransportRouteDetail transportRouteDetail) {
		return transportRouteDetailRepository.save(transportRouteDetail) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransportRouteDetail(Integer id) {
		transportRouteDetailRepository.deleteById(id);
		return " successfully deleted!";
	}
}
