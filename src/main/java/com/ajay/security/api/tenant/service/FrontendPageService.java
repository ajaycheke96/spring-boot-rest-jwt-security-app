package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FrontendPage;
import com.ajay.security.api.tenant.repository.FrontendPageRepository;

@Service
@Transactional
public class FrontendPageService {

	@Autowired
	private FrontendPageRepository frontendPageRepository;

	public List<FrontendPage> getAllFrontendPages() {
		return frontendPageRepository.findAll();
	}

	public FrontendPage getOneFrontendPage(Integer id) {
		return frontendPageRepository.findById(id).get();
	}

	public String saveFrontendPage(FrontendPage frontendPage) {
		return frontendPageRepository.save(frontendPage) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateFrontendPage(FrontendPage frontendPage) {
		return frontendPageRepository.save(frontendPage) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneFrontendPage(Integer id) {
		frontendPageRepository.deleteById(id);
		return " successfully deleted!";
	}
}
