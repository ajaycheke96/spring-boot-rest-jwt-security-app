package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TransferCertificate;
import com.ajay.security.api.tenant.repository.TransferCertificateRepository;

@Service
@Transactional
public class TransferCertificateService {

	@Autowired
	private TransferCertificateRepository transferCertificateRepository;

	public List<TransferCertificate> getAllTransferCertificates() {
		return transferCertificateRepository.findAll();
	}

	public TransferCertificate getOneTransferCertificate(Integer id) {
		return transferCertificateRepository.findById(id).get();
	}

	public String saveTransferCertificate(TransferCertificate transferCertificate) {
		return transferCertificateRepository.save(transferCertificate) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTransferCertificate(TransferCertificate transferCertificate) {
		return transferCertificateRepository.save(transferCertificate) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTransferCertificate(Integer id) {
		transferCertificateRepository.deleteById(id);
		return " successfully deleted!";
	}
}
