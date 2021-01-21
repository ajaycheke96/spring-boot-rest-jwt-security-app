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

import com.ajay.security.api.tenant.entity.TransportFeeDetail;
import com.ajay.security.api.tenant.service.TransportFeeDetailService;

@RestController
@RequestMapping("/transportFeeDetail")
public class TransportFeeDetailController {

	@Autowired
	private TransportFeeDetailService transportFeeDetailService;

	@GetMapping("/all")
	public List<TransportFeeDetail> getAllTransportFeeDetail() {
		return transportFeeDetailService.getAllTransportFeeDetails();
	}

	@GetMapping("/one/{id}")
	public TransportFeeDetail getOneTransportFeeDetail(@PathVariable Integer id) {
		return transportFeeDetailService.getOneTransportFeeDetail(id);
	}

	@PostMapping("/save")
	public String saveTransportFeeDetail(@RequestBody TransportFeeDetail transportFeeDetail) {
		return transportFeeDetailService.saveTransportFeeDetail(transportFeeDetail);
	}

	@PutMapping("/update")
	public String updateTransportFeeDetail(@RequestBody TransportFeeDetail transportFeeDetail) {
		return transportFeeDetailService.updateTransportFeeDetail(transportFeeDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransportFeeDetail(@PathVariable Integer id) {
		return transportFeeDetailService.deleteOneTransportFeeDetail(id);
	}
}
