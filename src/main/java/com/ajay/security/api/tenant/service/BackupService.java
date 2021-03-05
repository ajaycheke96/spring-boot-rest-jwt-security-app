package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Backup;
import com.ajay.security.api.tenant.repository.BackupRepository;

@Service
@Transactional
public class BackupService {

	@Autowired
	private BackupRepository backupRepository;

	public List<Backup> getAllBackups() {
		return backupRepository.findAll();
	}

	public Backup getOneBackup(Integer id) {
		return backupRepository.findById(id).get();
	}

	public Backup saveBackup(Backup backup) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (backup.getCreatedAt() == null)
			backup.setCreatedAt(currentTimestamp);
		backup.setUpdatedAt(currentTimestamp);

		return backupRepository.save(backup);
	}

	public String deleteOneBackup(Backup backup) {
		String result = null;
		if (backupRepository.existsById(backup.getId())) {
			backupRepository.delete(backup);
			result = "Backup deleted!";
		} else {
			result = "Backup not found! Or Already deleted!";
		}
		return result;
	}

}
