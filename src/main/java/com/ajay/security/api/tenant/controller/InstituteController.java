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

import com.ajay.security.api.tenant.entity.Institute;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.InstituteService;

@RestController
@RequestMapping("/institute")
@CrossOrigin(origins = "*", maxAge = 3600)
public class InstituteController {

	@Autowired
	private InstituteService instituteService;

	@GetMapping("/listAllInstitute")
	public ApiResponse getAllInstitute() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Institute",
					instituteService.getAllInstitutes());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Institute Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneInstitute(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Institute", instituteService.getOneInstitute(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Institute Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveInstitute")
	public ApiResponse saveInstitute(@RequestBody Institute institute) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Institute saved!",
					instituteService.saveInstitute(institute));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Institute Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateInstitute")
	public ApiResponse updateInstitute(@RequestBody Institute institute) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Institute updated!",
					instituteService.saveInstitute(institute));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Institute Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteInstitute")
	public ApiResponse deleteOneInstitute(@RequestBody Institute institute) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, instituteService.deleteOneInstitute(institute),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Institute Service exception : " + e.getLocalizedMessage());
		}
	}
}
