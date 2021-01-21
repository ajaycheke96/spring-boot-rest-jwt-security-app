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

	public String saveTelescopeMonitoring(TelescopeMonitoring telescopeMonitoring) {
		return telescopeMonitoringRepository.save(telescopeMonitoring) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTelescopeMonitoring(TelescopeMonitoring telescopeMonitoring) {
		return telescopeMonitoringRepository.save(telescopeMonitoring) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTelescopeMonitoring(TelescopeMonitoring telescopeMonitoring) {
		telescopeMonitoringRepository.delete(telescopeMonitoring);
		return " successfully deleted!";
	}
}
