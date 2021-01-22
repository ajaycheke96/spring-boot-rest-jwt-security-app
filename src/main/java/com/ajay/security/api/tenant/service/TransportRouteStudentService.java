package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TransportRouteStudent;
import com.ajay.security.api.tenant.repository.TransportRouteStudentRepository;

@Service
@Transactional
public class TransportRouteStudentService {

	@Autowired
	private TransportRouteStudentRepository transportRouteStudentRepository;

	public List<TransportRouteStudent> getAllTransportRouteStudents() {
		return transportRouteStudentRepository.findAll();
	}

	public TransportRouteStudent getOneTransportRouteStudent(Integer id) {
		return transportRouteStudentRepository.findById(id).get();
	}

	public String saveTransportRouteStudent(TransportRouteStudent transportRouteStudent) {
		return transportRouteStudentRepository.save(transportRouteStudent) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTransportRouteStudent(TransportRouteStudent transportRouteStudent) {
		return transportRouteStudentRepository.save(transportRouteStudent) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransportRouteStudent(Integer id) {
		transportRouteStudentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
