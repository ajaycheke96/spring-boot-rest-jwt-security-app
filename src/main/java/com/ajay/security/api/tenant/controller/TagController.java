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

import com.ajay.security.api.tenant.entity.Tag;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.TagService;

@RestController
@RequestMapping("/tag")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TagController {

	@Autowired
	private TagService tagService;

	@GetMapping("/listAllTag")
	public ApiResponse getAllTag() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Tag", tagService.getAllTags());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Tag Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneTag(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Tag", tagService.getOneTag(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Tag Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveTag")
	public ApiResponse saveTag(@RequestBody Tag tag) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Tag saved!", tagService.saveTag(tag));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Tag Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateTag")
	public ApiResponse updateTag(@RequestBody Tag tag) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Tag updated!", tagService.saveTag(tag));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Tag Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteTag")
	public ApiResponse deleteOneTag(@RequestBody Tag tag) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, tagService.deleteOneTag(tag), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Tag Service exception : " + e.getLocalizedMessage());
		}
	}
}
