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

import com.ajay.security.api.tenant.entity.Tag;
import com.ajay.security.api.tenant.service.TagService;

@RestController
@RequestMapping("/tag")
public class TagController {

	@Autowired
	private TagService tagService;

	@GetMapping("/all")
	public List<Tag> getAllTag() {
		return tagService.getAllTags();
	}

	@GetMapping("/one/{id}")
	public Tag getOneTag(@PathVariable Integer id) {
		return tagService.getOneTag(id);
	}

	@PostMapping("/save")
	public String saveTag(@RequestBody Tag tag) {
		return tagService.saveTag(tag);
	}

	@PutMapping("/update")
	public String updateTag(@RequestBody Tag tag) {
		return tagService.updateTag(tag);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneTag(@PathVariable Integer id) {
		return tagService.deleteOneTag(id);
	}
}
