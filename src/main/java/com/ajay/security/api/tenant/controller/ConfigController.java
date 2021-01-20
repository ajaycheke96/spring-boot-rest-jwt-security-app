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

import com.ajay.security.api.tenant.entity.Config;
import com.ajay.security.api.tenant.service.ConfigService;

@RestController
@RequestMapping("/config")
public class ConfigController {

	@Autowired
	private ConfigService configService;

	@GetMapping("/all")
	public List<Config> getAllConfig() {
		return configService.getAllConfigs();
	}

	@GetMapping("/one/{id}")
	public Config getOneConfig(@PathVariable Integer id) {
		return configService.getOneConfig(id);
	}

	@PostMapping("/save")
	public String saveConfig(@RequestBody Config config) {
		return configService.saveConfig(config);
	}

	@PutMapping("/update")
	public String updateConfig(@RequestBody Config config) {
		return configService.updateConfig(config);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneConfig(@PathVariable Integer id) {
		return configService.deleteOneConfig(id);
	}
}
