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

	public Config saveConfig(Config config) {
		return configRepository.save(config);
	}

	public String deleteOneConfig(Config config) {
		String result = null;
		if (configRepository.existsById(config.getId())) {
			configRepository.delete(config);
			result = " Config deleted!";
		} else {
			result = "Config Not Found! or Already deleted!";
		}
		return result;
	}
}
