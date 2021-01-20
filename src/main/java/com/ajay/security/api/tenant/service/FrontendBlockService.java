package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FrontendBlock;
import com.ajay.security.api.tenant.repository.FrontendBlockRepository;

@Service
@Transactional
public class FrontendBlockService {

	@Autowired
	private FrontendBlockRepository frontendBlockRepository;

	public List<FrontendBlock> getAllFrontendBlocks() {
		return frontendBlockRepository.findAll();
	}

	public FrontendBlock getOneFrontendBlock(Integer id) {
		return frontendBlockRepository.findById(id).get();
	}

	public String saveFrontendBlock(FrontendBlock frontendBlock) {
		return frontendBlockRepository.save(frontendBlock) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updateFrontendBlock(FrontendBlock frontendBlock) {
		return frontendBlockRepository.save(frontendBlock) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOneFrontendBlock(Integer id) {
		frontendBlockRepository.deleteById(id);
		return " successfully deleted!";
	}
}
