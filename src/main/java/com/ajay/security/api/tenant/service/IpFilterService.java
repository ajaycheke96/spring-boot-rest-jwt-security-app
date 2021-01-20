package com.ajay.security.api.tenant.service;

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

	public String saveIpFilter(IpFilter ipFilter) {
		return ipFilterRepository.save(ipFilter) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateIpFilter(IpFilter ipFilter) {
		return ipFilterRepository.save(ipFilter) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneIpFilter(Integer id) {
		ipFilterRepository.deleteById(id);
		return " successfully deleted!";
	}
}
