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

import com.ajay.security.api.tenant.entity.PayHead;
import com.ajay.security.api.tenant.service.PayHeadService;

@RestController
@RequestMapping("/payHead")
public class PayHeadController {

	@Autowired
	private PayHeadService payHeadService;

	@GetMapping("/all")
	public List<PayHead> getAllPayHead() {
		return payHeadService.getAllPayHeads();
	}

	@GetMapping("/one/{id}")
	public PayHead getOnePayHead(@PathVariable Integer id) {
		return payHeadService.getOnePayHead(id);
	}

	@PostMapping("/save")
	public String savePayHead(@RequestBody PayHead payHead) {
		return payHeadService.savePayHead(payHead);
	}

	@PutMapping("/update")
	public String updatePayHead(@RequestBody PayHead payHead) {
		return payHeadService.updatePayHead(payHead);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOnePayHead(@PathVariable Integer id) {
		return payHeadService.deleteOnePayHead(id);
	}
}
