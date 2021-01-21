package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TelescopeEntry;
import com.ajay.security.api.tenant.repository.TelescopeEntryRepository;

@Service
@Transactional
public class TelescopeEntryService {

	@Autowired
	private TelescopeEntryRepository telescopeEntryRepository;

	public List<TelescopeEntry> getAllTelescopeEntrys() {
		return telescopeEntryRepository.findAll();
	}

	public TelescopeEntry getOneTelescopeEntry(Integer sequence) {
		return telescopeEntryRepository.findBySequence(sequence);
	}

	public String saveTelescopeEntry(TelescopeEntry telescopeEntry) {
		return telescopeEntryRepository.save(telescopeEntry) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTelescopeEntry(TelescopeEntry telescopeEntry) {
		return telescopeEntryRepository.save(telescopeEntry) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTelescopeEntry(TelescopeEntry telescopeEntry) {
		telescopeEntryRepository.delete(telescopeEntry);
		return " successfully deleted!";
	}
}
