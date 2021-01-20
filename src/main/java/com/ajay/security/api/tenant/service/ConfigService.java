package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Config;
import com.ajay.security.api.tenant.repository.ConfigRepository;

@Service
public class ConfigService {

	@Autowired
	private ConfigRepository configRepository;

	public List<Config> getAllConfigs() {
		return configRepository.findAll();
	}

	public Config getOneConfig(Integer id) {
		return configRepository.findById(id).get();
	}

	public String saveConfig(Config config) {
		return configRepository.save(config) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateConfig(Config config) {
		return configRepository.save(config) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneConfig(Integer id) {
		configRepository.deleteById(id);
		return " successfully deleted!";
	}
}
