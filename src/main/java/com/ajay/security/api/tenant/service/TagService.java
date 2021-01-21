package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Tag;
import com.ajay.security.api.tenant.repository.TagRepository;

@Service
@Transactional
public class TagService {

	@Autowired
	private TagRepository tagRepository;

	public List<Tag> getAllTags() {
		return tagRepository.findAll();
	}

	public Tag getOneTag(Integer id) {
		return tagRepository.findById(id).get();
	}

	public String saveTag(Tag tag) {
		return tagRepository.save(tag) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateTag(Tag tag) {
		return tagRepository.save(tag) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneTag(Integer id) {
		tagRepository.deleteById(id);
		return " successfully deleted!";
	}
}
