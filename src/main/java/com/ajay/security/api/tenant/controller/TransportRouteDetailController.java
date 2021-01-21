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

import com.ajay.security.api.tenant.entity.TransportRouteDetail;
import com.ajay.security.api.tenant.service.TransportRouteDetailService;

@RestController
@RequestMapping("/transportRouteDetail")
public class TransportRouteDetailController {

	@Autowired
	private TransportRouteDetailService transportRouteDetailService;

	@GetMapping("/all")
	public List<TransportRouteDetail> getAllTransportRouteDetail() {
		return transportRouteDetailService.getAllTransportRouteDetails();
	}

	@GetMapping("/one/{id}")
	public TransportRouteDetail getOneTransportRouteDetail(@PathVariable Integer id) {
		return transportRouteDetailService.getOneTransportRouteDetail(id);
	}

	@PostMapping("/save")
	public String saveTransportRouteDetail(@RequestBody TransportRouteDetail transportRouteDetail) {
		return transportRouteDetailService.saveTransportRouteDetail(transportRouteDetail);
	}

	@PutMapping("/update")
	public String updateTransportRouteDetail(@RequestBody TransportRouteDetail transportRouteDetail) {
		return transportRouteDetailService.updateTransportRouteDetail(transportRouteDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransportRouteDetail(@PathVariable Integer id) {
		return transportRouteDetailService.deleteOneTransportRouteDetail(id);
	}
}
