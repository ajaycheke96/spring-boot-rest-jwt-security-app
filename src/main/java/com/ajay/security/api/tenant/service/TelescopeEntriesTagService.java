package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.TelescopeEntriesTag;
import com.ajay.security.api.tenant.repository.TelescopeEntriesTagRepository;

@Service
@Transactional
public class TelescopeEntriesTagService {

	@Autowired
	private TelescopeEntriesTagRepository telescopeEntriesTagRepository;

	public List<TelescopeEntriesTag> getAllTelescopeEntriesTags() {
		return telescopeEntriesTagRepository.findAll();
	}

	public TelescopeEntriesTag getOneTelescopeEntriesTag(String tag) {
		return telescopeEntriesTagRepository.findByTag(tag);
	}

	public String saveTelescopeEntriesTag(TelescopeEntriesTag telescopeEntriesTag) {
		return telescopeEntriesTagRepository.save(telescopeEntriesTag) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateTelescopeEntriesTag(TelescopeEntriesTag telescopeEntriesTag) {
		return telescopeEntriesTagRepository.save(telescopeEntriesTag) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneTelescopeEntriesTag(TelescopeEntriesTag telescopeEntriesTag) {
		telescopeEntriesTagRepository.delete(telescopeEntriesTag);
		return " successfully deleted!";
	}
}
