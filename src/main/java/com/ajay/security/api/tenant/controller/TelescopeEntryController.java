package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.TelescopeEntry;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TelescopeEntryService;

@RestController
@RequestMapping("/telescopeEntry")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TelescopeEntryController {

	@Autowired
	private TelescopeEntryService telescopeEntryService;

	@GetMapping("/listAllTelescopeEntry")
	public ApiResponse getAllTelescopeEntry() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of TelescopeEntry",
					telescopeEntryService.getAllTelescopeEntrys());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeEntry Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTelescopeEntry(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TelescopeEntry",
					telescopeEntryService.getOneTelescopeEntry(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeEntry Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTelescopeEntry")
	public ApiResponse saveTelescopeEntry(@RequestBody TelescopeEntry telescopeEntry) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TelescopeEntry saved!",
					telescopeEntryService.saveTelescopeEntry(telescopeEntry));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeEntry Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTelescopeEntry")
	public ApiResponse updateTelescopeEntry(@RequestBody TelescopeEntry telescopeEntry) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "TelescopeEntry updated!",
					telescopeEntryService.saveTelescopeEntry(telescopeEntry));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeEntry Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTelescopeEntry")
	public ApiResponse deleteOneTelescopeEntry(@RequestBody TelescopeEntry telescopeEntry) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					telescopeEntryService.deleteOneTelescopeEntry(telescopeEntry), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"TelescopeEntry Service exception : " + e.getLocalizedMessage());
		}
	}
}
