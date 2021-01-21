package com.ajay.security.api.tenant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.security.api.tenant.entity.TelescopeMonitoring;

@Repository
public interface TelescopeMonitoringRepository extends JpaRepository<TelescopeMonitoring, String> {

	public TelescopeMonitoring findByTag(String tag);

}
