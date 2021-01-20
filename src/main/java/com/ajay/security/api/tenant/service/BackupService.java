package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Backup;
import com.ajay.security.api.tenant.repository.BackupRepository;

@Service
public class BackupService {

	@Autowired
	private BackupRepository backupRepository;

	public List<Backup> getAllBackups() {
		return backupRepository.findAll();
	}

	public Backup getOneBackup(Integer id) {
		return backupRepository.findById(id).get();
	}

	public String saveBackup(Backup backup) {
		return backupRepository.save(backup) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBackup(Backup backup) {
		return backupRepository.save(backup) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBackup(Integer id) {
		backupRepository.deleteById(id);
		return " successfully deleted!";
	}

}
