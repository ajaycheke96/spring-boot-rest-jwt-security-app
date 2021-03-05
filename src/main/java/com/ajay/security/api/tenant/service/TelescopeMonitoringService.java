package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TelescopeMonitoring;
import com.ajay.security.api.tenant.repository.TelescopeMonitoringRepository;

@Service
@Transactional
public class TelescopeMonitoringService {

	@Autowired
	private TelescopeMonitoringRepository telescopeMonitoringRepository;

	public List<TelescopeMonitoring> getAllTelescopeMonitorings() {
		return telescopeMonitoringRepository.findAll();
	}

	public TelescopeMonitoring getOneTelescopeMonitoring(String tag) {
		return telescopeMonitoringRepository.findByTag(tag);
	}

	public TelescopeMonitoring saveTelescopeMonitoring(TelescopeMonitoring telescopeMonitoring) {
		return telescopeMonitoringRepository.save(telescopeMonitoring);
	}

	public String deleteOneTelescopeMonitoring(TelescopeMonitoring telescopeMonitoring) {
		String result = null;
		if (telescopeMonitoringRepository.existsById(telescopeMonitoring.getTag())) {
			telescopeMonitoringRepository.delete(telescopeMonitoring);
			result = " TelescopeMonitoring deleted!";
		} else {
			result = "TelescopeMonitoring Not Found! or Already deleted!";
		}
		return result;
	}
}
