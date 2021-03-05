package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.IpFilter;
import com.ajay.security.api.tenant.repository.IpFilterRepository;

@Service
@Transactional
public class IpFilterService {

	@Autowired
	private IpFilterRepository ipFilterRepository;

	public List<IpFilter> getAllIpFilters() {
		return ipFilterRepository.findAll();
	}

	public IpFilter getOneIpFilter(Integer id) {
		return ipFilterRepository.findById(id).get();
	}

	public IpFilter saveIpFilter(IpFilter ipFilter) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (ipFilter.getCreatedAt() == null)
			ipFilter.setCreatedAt(currentTimestamp);
		ipFilter.setUpdatedAt(currentTimestamp);
		return ipFilterRepository.save(ipFilter);
	}

	public String deleteOneIpFilter(IpFilter ipFilter) {
		String result = null;
		if (ipFilterRepository.existsById(ipFilter.getId())) {
			ipFilterRepository.delete(ipFilter);
			result = " IpFilter deleted!";
		} else {
			result = "IpFilter Not Found! or Already deleted!";
		}
		return result;
	}
}
