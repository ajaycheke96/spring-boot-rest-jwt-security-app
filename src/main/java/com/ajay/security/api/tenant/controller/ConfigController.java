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

import com.ajay.security.api.tenant.entity.Config;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.ConfigService;

@RestController
@RequestMapping("/config")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ConfigController {

	@Autowired
	private ConfigService configService;

	@GetMapping("/listAllConfig")
	public ApiResponse getAllConfig() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of Config", configService.getAllConfigs());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Config Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneConfig(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Config", configService.getOneConfig(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Config Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveConfig")
	public ApiResponse saveConfig(@RequestBody Config config) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Config saved!", configService.saveConfig(config));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Config Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateConfig")
	public ApiResponse updateConfig(@RequestBody Config config) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "Config updated!", configService.saveConfig(config));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Config Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteConfig")
	public ApiResponse deleteOneConfig(@RequestBody Config config) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, configService.deleteOneConfig(config), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"Config Service exception : " + e.getLocalizedMessage());
		}
	}
}
