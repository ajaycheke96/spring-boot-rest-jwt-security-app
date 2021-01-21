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

import com.ajay.security.api.tenant.entity.TelescopeEntry;
import com.ajay.security.api.tenant.service.TelescopeEntryService;

@RestController
@RequestMapping("/telescopeEntry")
public class TelescopeEntryController {

	@Autowired
	private TelescopeEntryService telescopeEntryService;

	@GetMapping("/all")
	public List<TelescopeEntry> getAllTelescopeEntry() {
		return telescopeEntryService.getAllTelescopeEntrys();
	}

	@GetMapping("/one/{id}")
	public TelescopeEntry getOneTelescopeEntry(@PathVariable Integer id) {
		return telescopeEntryService.getOneTelescopeEntry(id);
	}

	@PostMapping("/save")
	public String saveTelescopeEntry(@RequestBody TelescopeEntry telescopeEntry) {
		return telescopeEntryService.saveTelescopeEntry(telescopeEntry);
	}

	@PutMapping("/update")
	public String updateTelescopeEntry(@RequestBody TelescopeEntry telescopeEntry) {
		return telescopeEntryService.updateTelescopeEntry(telescopeEntry);
	}

	@DeleteMapping("/delete")
	public String deleteOneTelescopeEntry(@RequestBody TelescopeEntry telescopeEntry) {
		return telescopeEntryService.deleteOneTelescopeEntry(telescopeEntry);
	}
}
