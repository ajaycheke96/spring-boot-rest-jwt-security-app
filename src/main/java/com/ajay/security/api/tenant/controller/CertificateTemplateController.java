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

import com.ajay.security.api.tenant.entity.CertificateTemplate;
import com.ajay.security.api.tenant.service.CertificateTemplateService;

@RestController
@RequestMapping("/certificateTemplate")
public class CertificateTemplateController {

	@Autowired
	private CertificateTemplateService certificateTemplateService;

	@GetMapping("/all")
	public List<CertificateTemplate> getAllCertificateTemplate() {
		return certificateTemplateService.getAllCertificateTemplates();
	}

	@GetMapping("/one/{id}")
	public CertificateTemplate getOneCertificateTemplate(@PathVariable Integer id) {
		return certificateTemplateService.getOneCertificateTemplate(id);
	}

	@PostMapping("/save")
	public String saveCertificateTemplate(@RequestBody CertificateTemplate certificateTemplate) {
		return certificateTemplateService.saveCertificateTemplate(certificateTemplate);
	}

	@PutMapping("/update")
	public String updateCertificateTemplate(@RequestBody CertificateTemplate certificateTemplate) {
		return certificateTemplateService.updateCertificateTemplate(certificateTemplate);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneCertificateTemplate(@PathVariable Integer id) {
		return certificateTemplateService.deleteOneCertificateTemplate(id);
	}
}
