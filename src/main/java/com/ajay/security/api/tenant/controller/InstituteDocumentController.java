package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.InstituteDocument;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.InstituteDocumentService;

@RestController
@RequestMapping("/instituteDocument")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InstituteDocumentController {

	@Autowired
	private InstituteDocumentService instituteDocumentService;

	@GetMapping("/listAllInstituteDocument")
	public ApiResponse getAllInstituteDocument() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of InstituteDocument",
					instituteDocumentService.getAllInstituteDocuments());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"InstituteDocument Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneInstituteDocument(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "InstituteDocument",
					instituteDocumentService.getOneInstituteDocument(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"InstituteDocument Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveInstituteDocument")
	public ApiResponse saveInstituteDocument(@RequestBody InstituteDocument instituteDocument) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "InstituteDocument saved!",
					instituteDocumentService.saveInstituteDocument(instituteDocument));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"InstituteDocument Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateInstituteDocument")
	public ApiResponse updateInstituteDocument(@RequestBody InstituteDocument instituteDocument) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "InstituteDocument updated!",
					instituteDocumentService.saveInstituteDocument(instituteDocument));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"InstituteDocument Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteInstituteDocument")
	public ApiResponse deleteOneInstituteDocument(@RequestBody InstituteDocument instituteDocument) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					instituteDocumentService.deleteOneInstituteDocument(instituteDocument), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"InstituteDocument Service exception : " + e.getLocalizedMessage());
		}
	}
}
