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

import com.ajay.security.api.tenant.entity.TransportFee;
import com.ajay.security.api.tenant.service.TransportFeeService;

@RestController
@RequestMapping("/transportFee")
public class TransportFeeController {

	@Autowired
	private TransportFeeService transportFeeService;

	@GetMapping("/all")
	public List<TransportFee> getAllTransportFee() {
		return transportFeeService.getAllTransportFees();
	}

	@GetMapping("/one/{id}")
	public TransportFee getOneTransportFee(@PathVariable Integer id) {
		return transportFeeService.getOneTransportFee(id);
	}

	@PostMapping("/save")
	public String saveTransportFee(@RequestBody TransportFee transportFee) {
		return transportFeeService.saveTransportFee(transportFee);
	}

	@PutMapping("/update")
	public String updateTransportFee(@RequestBody TransportFee transportFee) {
		return transportFeeService.updateTransportFee(transportFee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransportFee(@PathVariable Integer id) {
		return transportFeeService.deleteOneTransportFee(id);
	}
}
