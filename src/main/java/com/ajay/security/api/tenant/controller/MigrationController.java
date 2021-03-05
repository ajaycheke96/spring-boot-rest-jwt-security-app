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

import com.ajay.security.api.tenant.entity.Migration;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.MigrationService;

@RestController
@RequestMapping("/migration")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MigrationController {

	@Autowired
	private MigrationService migrationService;

	@GetMapping("/listAllMigration")
	public ApiResponse getAllMigration() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Migration",
					migrationService.getAllMigrations());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Migration Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneMigration(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Migration", migrationService.getOneMigration(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Migration Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveMigration")
	public ApiResponse saveMigration(@RequestBody Migration migration) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Migration saved!",
					migrationService.saveMigration(migration));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Migration Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateMigration")
	public ApiResponse updateMigration(@RequestBody Migration migration) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Migration updated!",
					migrationService.saveMigration(migration));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Migration Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteMigration")
	public ApiResponse deleteOneMigration(@RequestBody Migration migration) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, migrationService.deleteOneMigration(migration),
					null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Migration Service exception : " + e.getLocalizedMessage());
		}
	}
}
