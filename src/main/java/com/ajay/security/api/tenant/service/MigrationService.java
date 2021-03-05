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

	public Migration saveMigration(Migration migration) {
		return migrationRepository.save(migration);
	}

	public String deleteOneMigration(Migration migration) {
		String result = null;
		if (migrationRepository.existsById(migration.getId())) {
			migrationRepository.delete(migration);
			result = " Migration deleted!";
		} else {
			result = "Migration Not Found! or Already deleted!";
		}
		return result;
	}
}
