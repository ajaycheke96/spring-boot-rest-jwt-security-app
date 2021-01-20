package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Certificate;
import com.ajay.security.api.tenant.repository.CertificateRepository;

@Service
public class CertificateService {

	@Autowired
	private CertificateRepository certificateRepository;

	public List<Certificate> getAllCertificates() {
		return certificateRepository.findAll();
	}

	public Certificate getOneCertificate(Integer id) {
		return certificateRepository.findById(id).get();
	}

	public String saveCertificate(Certificate certificate) {
		return certificateRepository.save(certificate) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateCertificate(Certificate certificate) {
		return certificateRepository.save(certificate) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneCertificate(Integer id) {
		certificateRepository.deleteById(id);
		return " successfully deleted!";
	}
}
