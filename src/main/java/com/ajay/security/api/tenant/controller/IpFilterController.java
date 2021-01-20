package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.IpFilter;
import com.ajay.security.api.tenant.service.IpFilterService;

@RestController
@RequestMapping("/ipFilter")
public class IpFilterController {

	@Autowired
	private IpFilterService ipFilterService;

	@GetMapping("/all")
	public List<IpFilter> getAllIpFilter() {
		return ipFilterService.getAllIpFilters();
	}

	@GetMapping("/one/{id}")
	public IpFilter getOneIpFilter(@PathVariable Integer id) {
		return ipFilterService.getOneIpFilter(id);
	}

	@PostMapping("/save")
	public String saveIpFilter(@RequestBody IpFilter ipFilter) {
		return ipFilterService.saveIpFilter(ipFilter);
	}

	@PutMapping("/update")
	public String updateIpFilter(@RequestBody IpFilter ipFilter) {
		return ipFilterService.updateIpFilter(ipFilter);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneIpFilter(@PathVariable Integer id) {
		return ipFilterService.deleteOneIpFilter(id);
	}
}
