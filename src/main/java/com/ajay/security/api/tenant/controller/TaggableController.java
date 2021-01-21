package com.ajay.security.api.tenant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ajay.security.api.tenant.entity.Taggable;
import com.ajay.security.api.tenant.service.TaggableService;

@RestController
@RequestMapping("/taggable")
public class TaggableController {

	@Autowired
	private TaggableService taggableService;

	@GetMapping("/all")
	public List<Taggable> getAllTaggable() {
		return taggableService.getAllTaggables();
	}

	@GetMapping("/one/{id}")
	public Taggable getOneTaggable(@PathVariable Integer id) {
		return taggableService.getOneTaggable(id);
	}

	@PostMapping("/save")
	public String saveTaggable(@RequestBody Taggable taggable) {
		return taggableService.saveTaggable(taggable);
	}

	@PutMapping("/update")
	public String updateTaggable(@RequestBody Taggable taggable) {
		return taggableService.updateTaggable(taggable);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTaggable(@PathVariable Integer id) {
		return taggableService.deleteOneTaggable(id);
	}
}
