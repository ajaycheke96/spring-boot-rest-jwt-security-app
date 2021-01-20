package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.InstituteDocument;
import com.ajay.security.api.tenant.repository.InstituteDocumentRepository;

@Service
@Transactional
public class InstituteDocumentService {

	@Autowired
	private InstituteDocumentRepository instituteDocumentRepository;

	public List<InstituteDocument> getAllInstituteDocuments() {
		return instituteDocumentRepository.findAll();
	}

	public InstituteDocument getOneInstituteDocument(Integer id) {
		return instituteDocumentRepository.findById(id).get();
	}

	public String saveInstituteDocument(InstituteDocument instituteDocument) {
		return instituteDocumentRepository.save(instituteDocument) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateInstituteDocument(InstituteDocument instituteDocument) {
		return instituteDocumentRepository.save(instituteDocument) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneInstituteDocument(Integer id) {
		instituteDocumentRepository.deleteById(id);
		return " successfully deleted!";
	}
}
