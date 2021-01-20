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

import com.ajay.security.api.tenant.entity.InstituteDocument;
import com.ajay.security.api.tenant.service.InstituteDocumentService;

@RestController
@RequestMapping("/instituteDocument")
public class InstituteDocumentController {

	@Autowired
	private InstituteDocumentService instituteDocumentService;

	@GetMapping("/all")
	public List<InstituteDocument> getAllInstituteDocument() {
		return instituteDocumentService.getAllInstituteDocuments();
	}

	@GetMapping("/one/{id}")
	public InstituteDocument getOneInstituteDocument(@PathVariable Integer id) {
		return instituteDocumentService.getOneInstituteDocument(id);
	}

	@PostMapping("/save")
	public String saveInstituteDocument(@RequestBody InstituteDocument instituteDocument) {
		return instituteDocumentService.saveInstituteDocument(instituteDocument);
	}

	@PutMapping("/update")
	public String updateInstituteDocument(@RequestBody InstituteDocument instituteDocument) {
		return instituteDocumentService.updateInstituteDocument(instituteDocument);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneInstituteDocument(@PathVariable Integer id) {
		return instituteDocumentService.deleteOneInstituteDocument(id);
	}
}
