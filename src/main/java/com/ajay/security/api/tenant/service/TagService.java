package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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
		List<Tag> findAll = tagRepository.findAll();
		System.out.println(findAll);
		return findAll;
	}

	public Tag getOneTag(Integer id) {
		Tag tag = tagRepository.findById(id).get();
		System.out.println("Tag: " + tag);
		return tag;
	}

	public Tag saveTag(Tag tag) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (tag.getCreatedAt() == null)
			tag.setCreatedAt(timestamp);
		tag.setUpdatedAt(timestamp);
		return tagRepository.save(tag);
	}

	public String deleteOneTag(Tag tag) {
		String result = null;
		if (tagRepository.existsById(tag.getId())) {
			tagRepository.delete(tag);
			result = " Tag deleted!";
		} else {
			result = "Tag Not Found! or Already deleted!";
		}
		return result;
	}
}
