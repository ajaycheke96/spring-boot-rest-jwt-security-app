package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public InstituteDocument saveInstituteDocument(InstituteDocument instituteDocument) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (instituteDocument.getCreatedAt() == null)
			instituteDocument.setCreatedAt(currentTimestamp);
		instituteDocument.setUpdatedAt(currentTimestamp);
		return instituteDocumentRepository.save(instituteDocument);
	}

	public String deleteOneInstituteDocument(InstituteDocument instituteDocument) {
		String result = null;
		if (instituteDocumentRepository.existsById(instituteDocument.getId())) {
			instituteDocumentRepository.delete(instituteDocument);
			result = " InstituteDocument deleted!";
		} else {
			result = "InstituteDocument Not Found! or Already deleted!";
		}
		return result;
	}
}
