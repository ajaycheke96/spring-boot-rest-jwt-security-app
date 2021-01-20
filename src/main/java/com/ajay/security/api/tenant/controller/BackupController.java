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

import com.ajay.security.api.tenant.entity.Backup;
import com.ajay.security.api.tenant.service.BackupService;

@RestController
@RequestMapping("/backup")
public class BackupController {

	@Autowired
	private BackupService backupService;

	@GetMapping("/all")
	public List<Backup> getAllBackup() {
		return backupService.getAllBackups();
	}

	@GetMapping("/one/{id}")
	public Backup getOneBackup(@PathVariable Integer id) {
		return backupService.getOneBackup(id);
	}

	@PostMapping("/save")
	public String saveBackup(@RequestBody Backup backup) {
		return backupService.saveBackup(backup);
	}

	@PutMapping("/update")
	public String updateBackup(@RequestBody Backup backup) {
		return backupService.updateBackup(backup);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneBackup(@PathVariable Integer id) {
		return backupService.deleteOneBackup(id);
	}
}
