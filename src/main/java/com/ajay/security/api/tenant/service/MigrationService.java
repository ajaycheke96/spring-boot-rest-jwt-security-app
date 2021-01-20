package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Migration;
import com.ajay.security.api.tenant.repository.MigrationRepository;

@Service
@Transactional
public class MigrationService {

	@Autowired
	private MigrationRepository migrationRepository;

	public List<Migration> getAllMigrations() {
		return migrationRepository.findAll();
	}

	public Migration getOneMigration(Integer id) {
		return migrationRepository.findById(id).get();
	}

	public String saveMigration(Migration migration) {
		return migrationRepository.save(migration) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateMigration(Migration migration) {
		return migrationRepository.save(migration) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneMigration(Integer id) {
		migrationRepository.deleteById(id);
		return " successfully deleted!";
	}
}
