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

import com.ajay.security.api.tenant.entity.FrontendPage;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.FrontendPageService;

@RestController
@RequestMapping("/frontendPage")
@CrossOrigin(origins = "*", maxAge = 3600)
public class FrontendPageController {

	@Autowired
	private FrontendPageService frontendPageService;

	@GetMapping("/listAllFrontendPage")
	public ApiResponse getAllFrontendPage() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of FrontendPage",
					frontendPageService.getAllFrontendPages());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FrontendPage Service exception : " + e.getLocalizedMessage());
		}

	}

	@GetMapping("/{id}")
	public ApiResponse getOneFrontendPage(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FrontendPage",
					frontendPageService.getOneFrontendPage(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FrontendPage Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveFrontendPage")
	public ApiResponse saveFrontendPage(@RequestBody FrontendPage frontendPage) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FrontendPage saved!",
					frontendPageService.saveFrontendPage(frontendPage));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FrontendPage Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateFrontendPage")
	public ApiResponse updateFrontendPage(@RequestBody FrontendPage frontendPage) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "FrontendPage updated!",
					frontendPageService.saveFrontendPage(frontendPage));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FrontendPage Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteFrontendPage")
	public ApiResponse deleteOneFrontendPage(@RequestBody FrontendPage frontendPage) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null,
					frontendPageService.deleteOneFrontendPage(frontendPage), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"FrontendPage Service exception : " + e.getLocalizedMessage());
		}
	}
}
