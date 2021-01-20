package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FrontendMenus;
import com.ajay.security.api.tenant.repository.FrontendMenusRepository;

@Service
@Transactional
public class FrontendMenusService {

	@Autowired
	private FrontendMenusRepository frontendMenusRepository;

	public List<FrontendMenus> getAllFrontendMenuss() {
		return frontendMenusRepository.findAll();
	}

	public FrontendMenus getOneFrontendMenus(Integer id) {
		return frontendMenusRepository.findById(id).get();
	}

	public String saveFrontendMenus(FrontendMenus frontendMenus) {
		return frontendMenusRepository.save(frontendMenus) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateFrontendMenus(FrontendMenus frontendMenus) {
		return frontendMenusRepository.save(frontendMenus) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneFrontendMenus(Integer id) {
		frontendMenusRepository.deleteById(id);
		return " successfully deleted!";
	}
}
