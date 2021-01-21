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

import com.ajay.security.api.tenant.entity.TransferCertificate;
import com.ajay.security.api.tenant.service.TransferCertificateService;

@RestController
@RequestMapping("/transferCertificate")
public class TransferCertificateController {

	@Autowired
	private TransferCertificateService transferCertificateService;

	@GetMapping("/all")
	public List<TransferCertificate> getAllTransferCertificate() {
		return transferCertificateService.getAllTransferCertificates();
	}

	@GetMapping("/one/{id}")
	public TransferCertificate getOneTransferCertificate(@PathVariable Integer id) {
		return transferCertificateService.getOneTransferCertificate(id);
	}

	@PostMapping("/save")
	public String saveTransferCertificate(@RequestBody TransferCertificate transferCertificate) {
		return transferCertificateService.saveTransferCertificate(transferCertificate);
	}

	@PutMapping("/update")
	public String updateTransferCertificate(@RequestBody TransferCertificate transferCertificate) {
		return transferCertificateService.updateTransferCertificate(transferCertificate);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTransferCertificate(@PathVariable Integer id) {
		return transferCertificateService.deleteOneTransferCertificate(id);
	}
}
