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

import com.ajay.security.api.tenant.entity.Migration;
import com.ajay.security.api.tenant.service.MigrationService;

@RestController
@RequestMapping("/migration")
public class MigrationController {

	@Autowired
	private MigrationService migrationService;

	@GetMapping("/all")
	public List<Migration> getAllMigration() {
		return migrationService.getAllMigrations();
	}

	@GetMapping("/one/{id}")
	public Migration getOneMigration(@PathVariable Integer id) {
		return migrationService.getOneMigration(id);
	}

	@PostMapping("/save")
	public String saveMigration(@RequestBody Migration migration) {
		return migrationService.saveMigration(migration);
	}

	@PutMapping("/update")
	public String updateMigration(@RequestBody Migration migration) {
		return migrationService.updateMigration(migration);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneMigration(@PathVariable Integer id) {
		return migrationService.deleteOneMigration(id);
	}
}
