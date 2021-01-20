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

import com.ajay.security.api.tenant.entity.Certificate;
import com.ajay.security.api.tenant.service.CertificateService;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

	@Autowired
	private CertificateService certificateService;

	@GetMapping("/all")
	public List<Certificate> getAllCertificate() {
		return certificateService.getAllCertificates();
	}

	@GetMapping("/one/{id}")
	public Certificate getOneCertificate(@PathVariable Integer id) {
		return certificateService.getOneCertificate(id);
	}

	@PostMapping("/save")
	public String saveCertificate(@RequestBody Certificate certificate) {
		return certificateService.saveCertificate(certificate);
	}

	@PutMapping("/update")
	public String updateCertificate(@RequestBody Certificate certificate) {
		return certificateService.updateCertificate(certificate);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCertificate(@PathVariable Integer id) {
		return certificateService.deleteOneCertificate(id);
	}
}
