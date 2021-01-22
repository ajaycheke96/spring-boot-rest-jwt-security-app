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

import com.ajay.security.api.tenant.entity.TransportStoppage;
import com.ajay.security.api.tenant.service.TransportStoppageService;

@RestController
@RequestMapping("/transportStoppage")
public class TransportStoppageController {

	@Autowired
	private TransportStoppageService transportStoppageService;

	@GetMapping("/all")
	public List<TransportStoppage> getAllTransportStoppage() {
		return transportStoppageService.getAllTransportStoppages();
	}

	@GetMapping("/one/{id}")
	public TransportStoppage getOneTransportStoppage(@PathVariable Integer id) {
		return transportStoppageService.getOneTransportStoppage(id);
	}

	@PostMapping("/save")
	public String saveTransportStoppage(@RequestBody TransportStoppage transportStoppage) {
		return transportStoppageService.saveTransportStoppage(transportStoppage);
	}

	@PutMapping("/update")
	public String updateTransportStoppage(@RequestBody TransportStoppage transportStoppage) {
		return transportStoppageService.updateTransportStoppage(transportStoppage);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransportStoppage(@PathVariable Integer id) {
		return transportStoppageService.deleteOneTransportStoppage(id);
	}
}
