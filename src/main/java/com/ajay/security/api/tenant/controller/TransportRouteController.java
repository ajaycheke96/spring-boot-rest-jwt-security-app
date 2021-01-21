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

import com.ajay.security.api.tenant.entity.TransportRoute;
import com.ajay.security.api.tenant.service.TransportRouteService;

@RestController
@RequestMapping("/transportRoute")
public class TransportRouteController {

	@Autowired
	private TransportRouteService transportRouteService;

	@GetMapping("/all")
	public List<TransportRoute> getAllTransportRoute() {
		return transportRouteService.getAllTransportRoutes();
	}

	@GetMapping("/one/{id}")
	public TransportRoute getOneTransportRoute(@PathVariable Integer id) {
		return transportRouteService.getOneTransportRoute(id);
	}

	@PostMapping("/save")
	public String saveTransportRoute(@RequestBody TransportRoute transportRoute) {
		return transportRouteService.saveTransportRoute(transportRoute);
	}

	@PutMapping("/update")
	public String updateTransportRoute(@RequestBody TransportRoute transportRoute) {
		return transportRouteService.updateTransportRoute(transportRoute);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransportRoute(@PathVariable Integer id) {
		return transportRouteService.deleteOneTransportRoute(id);
	}
}
