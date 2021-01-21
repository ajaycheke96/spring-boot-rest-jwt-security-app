package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.Taggable;
import com.ajay.security.api.tenant.repository.TaggableRepository;

@Service
@Transactional
public class TaggableService {

	@Autowired
	private TaggableRepository taggableRepository;

	public List<Taggable> getAllTaggables() {
		return taggableRepository.findAll();
	}

	public Taggable getOneTaggable(Integer id) {
		return taggableRepository.findById(id).get();
	}

	public String saveTaggable(Taggable taggable) {
		return taggableRepository.save(taggable) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateTaggable(Taggable taggable) {
		return taggableRepository.save(taggable) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneTaggable(Integer id) {
		taggableRepository.deleteById(id);
		return " successfully deleted!";
	}
}
