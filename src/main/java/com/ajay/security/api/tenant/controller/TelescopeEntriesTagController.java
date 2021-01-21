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

import com.ajay.security.api.tenant.entity.TelescopeEntriesTag;
import com.ajay.security.api.tenant.service.TelescopeEntriesTagService;

@RestController
@RequestMapping("/telescopeEntriesTag")
public class TelescopeEntriesTagController {

	@Autowired
	private TelescopeEntriesTagService telescopeEntriesTagService;

	@GetMapping("/all")
	public List<TelescopeEntriesTag> getAllTelescopeEntriesTag() {
		return telescopeEntriesTagService.getAllTelescopeEntriesTags();
	}

	@GetMapping("/one/{tag}")
	public TelescopeEntriesTag getOneTelescopeEntriesTag(@PathVariable String tag) {
		return telescopeEntriesTagService.getOneTelescopeEntriesTag(tag);
	}

	@PostMapping("/save")
	public String saveTelescopeEntriesTag(@RequestBody TelescopeEntriesTag telescopeEntriesTag) {
		return telescopeEntriesTagService.saveTelescopeEntriesTag(telescopeEntriesTag);
	}

	@PutMapping("/update")
	public String updateTelescopeEntriesTag(@RequestBody TelescopeEntriesTag telescopeEntriesTag) {
		return telescopeEntriesTagService.updateTelescopeEntriesTag(telescopeEntriesTag);
	}

	@DeleteMapping("/delete")
	public String deleteOneTelescopeEntriesTag(@RequestBody TelescopeEntriesTag telescopeEntriesTag) {
		return telescopeEntriesTagService.deleteOneTelescopeEntriesTag(telescopeEntriesTag);
	}
}
