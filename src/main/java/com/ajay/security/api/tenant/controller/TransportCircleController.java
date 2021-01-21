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

import com.ajay.security.api.tenant.entity.TransportCircle;
import com.ajay.security.api.tenant.service.TransportCircleService;

@RestController
@RequestMapping("/transportCircle")
public class TransportCircleController {

	@Autowired
	private TransportCircleService transportCircleService;

	@GetMapping("/all")
	public List<TransportCircle> getAllTransportCircle() {
		return transportCircleService.getAllTransportCircles();
	}

	@GetMapping("/one/{id}")
	public TransportCircle getOneTransportCircle(@PathVariable Integer id) {
		return transportCircleService.getOneTransportCircle(id);
	}

	@PostMapping("/save")
	public String saveTransportCircle(@RequestBody TransportCircle transportCircle) {
		return transportCircleService.saveTransportCircle(transportCircle);
	}

	@PutMapping("/update")
	public String updateTransportCircle(@RequestBody TransportCircle transportCircle) {
		return transportCircleService.updateTransportCircle(transportCircle);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransportCircle(@PathVariable Integer id) {
		return transportCircleService.deleteOneTransportCircle(id);
	}
}
