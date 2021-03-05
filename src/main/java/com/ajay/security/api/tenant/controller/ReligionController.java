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

import com.ajay.security.api.tenant.entity.Religion;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ReligionService;

@RestController
@RequestMapping("/religion")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReligionController {

	@Autowired
	private ReligionService religionService;

	@GetMapping("/listAllReligion")
	public ApiResponse getAllReligion() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Religion",
					religionService.getAllReligions());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Religion Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneReligion(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Religion", religionService.getOneReligion(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Religion Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveReligion")
	public ApiResponse saveReligion(@RequestBody Religion religion) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Religion saved!",
					religionService.saveReligion(religion));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Religion Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateReligion")
	public ApiResponse updateReligion(@RequestBody Religion religion) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Religion updated!",
					religionService.saveReligion(religion));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Religion Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteReligion")
	public ApiResponse deleteOneReligion(@RequestBody Religion religion) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, religionService.deleteOneReligion(religion), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Religion Service exception : " + e.getLocalizedMessage());
		}
	}
}
