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

import com.ajay.security.api.tenant.entity.Backup;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.BackupService;

@RestController
@RequestMapping("/backup")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BackupController {

	@Autowired
	private BackupService backupService;

	@GetMapping("/listAllBackup")
	public ApiResponse getAllBackup() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Backup", backupService.getAllBackups());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Backup Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneBackup(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Backup", backupService.getOneBackup(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Backup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveBackup")
	public ApiResponse saveBackup(@RequestBody Backup backup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Backup saved!", backupService.saveBackup(backup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Backup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateBackup")
	public ApiResponse updateBackup(@RequestBody Backup backup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Backup updated!", backupService.saveBackup(backup));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Backup Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteBackup")
	public ApiResponse deleteOneBackup(@RequestBody Backup backup) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, backupService.deleteOneBackup(backup), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Backup Service exception : " + e.getLocalizedMessage());
		}
	}
}
