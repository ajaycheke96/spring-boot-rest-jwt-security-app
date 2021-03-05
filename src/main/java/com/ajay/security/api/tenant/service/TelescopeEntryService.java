package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public TelescopeEntry getOneTelescopeEntry(Integer id) {
		return telescopeEntryRepository.findById(id).get();
	}

	public TelescopeEntry saveTelescopeEntry(TelescopeEntry telescopeEntry) {
		Timestamp curTimestamp = new Timestamp(System.currentTimeMillis());
		telescopeEntry.setCreatedAt(curTimestamp);
		telescopeEntry.getTelescopeEntriesTags()
				.forEach(telescopeEntriesTag -> telescopeEntriesTag.setTelescopeEntry(telescopeEntry));
		return telescopeEntryRepository.save(telescopeEntry);
	}

	public String deleteOneTelescopeEntry(TelescopeEntry telescopeEntry) {
		String result = null;
		if (telescopeEntryRepository.existsById(telescopeEntry.getSequence())) {
			telescopeEntryRepository.delete(telescopeEntry);
			result = " TelescopeEntry deleted!";
		} else {
			result = "TelescopeEntry Not Found! or Already deleted!";
		}
		return result;
	}
}
