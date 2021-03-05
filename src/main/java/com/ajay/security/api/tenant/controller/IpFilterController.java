package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.IpFilter;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.IpFilterService;

@RestController
@RequestMapping("/ipFilter")
@CrossOrigin(origins = "*", maxAge = 3600)
public class IpFilterController {

	@Autowired
	private IpFilterService ipFilterService;

	@GetMapping("/listAllIpFilter")
	public ApiResponse getAllIpFilter() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of IpFilter",
					ipFilterService.getAllIpFilters());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IpFilter Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneIpFilter(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "IpFilter", ipFilterService.getOneIpFilter(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IpFilter Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveIpFilter")
	public ApiResponse saveIpFilter(@RequestBody IpFilter ipFilter) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "IpFilter saved!",
					ipFilterService.saveIpFilter(ipFilter));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IpFilter Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateIpFilter")
	public ApiResponse updateIpFilter(@RequestBody IpFilter ipFilter) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "IpFilter updated!",
					ipFilterService.saveIpFilter(ipFilter));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IpFilter Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteIpFilter")
	public ApiResponse deleteOneIpFilter(@RequestBody IpFilter ipFilter) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, ipFilterService.deleteOneIpFilter(ipFilter), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"IpFilter Service exception : " + e.getLocalizedMessage());
		}
	}
}
