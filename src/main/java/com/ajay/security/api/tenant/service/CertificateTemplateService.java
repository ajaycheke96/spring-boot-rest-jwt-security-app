package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.CertificateTemplate;
import com.ajay.security.api.tenant.repository.CertificateTemplateRepository;

@Service
public class CertificateTemplateService {

	@Autowired
	private CertificateTemplateRepository certificateTemplateRepository;

	public List<CertificateTemplate> getAllCertificateTemplates() {
		return certificateTemplateRepository.findAll();
	}

	public CertificateTemplate getOneCertificateTemplate(Integer id) {
		return certificateTemplateRepository.findById(id).get();
	}

	public String saveCertificateTemplate(CertificateTemplate certificateTemplate) {
		return certificateTemplateRepository.save(certificateTemplate) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateCertificateTemplate(CertificateTemplate certificateTemplate) {
		return certificateTemplateRepository.save(certificateTemplate) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCertificateTemplate(Integer id) {
		certificateTemplateRepository.deleteById(id);
		return " successfully deleted!";
	}
}
