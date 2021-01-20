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

import com.ajay.security.api.tenant.entity.FrontendBlock;
import com.ajay.security.api.tenant.service.FrontendBlockService;

@RestController
@RequestMapping("/frontendBlock")
public class FrontendBlockController {

	@Autowired
	private FrontendBlockService frontendBlockService;

	@GetMapping("/all")
	public List<FrontendBlock> getAllFrontendBlock() {
		return frontendBlockService.getAllFrontendBlocks();
	}

	@GetMapping("/one/{id}")
	public FrontendBlock getOneFrontendBlock(@PathVariable Integer id) {
		return frontendBlockService.getOneFrontendBlock(id);
	}

	@PostMapping("/save")
	public String saveFrontendBlock(@RequestBody FrontendBlock frontendBlock) {
		return frontendBlockService.saveFrontendBlock(frontendBlock);
	}

	@PutMapping("/update")
	public String updateFrontendBlock(@RequestBody FrontendBlock frontendBlock) {
		return frontendBlockService.updateFrontendBlock(frontendBlock);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFrontendBlock(@PathVariable Integer id) {
		return frontendBlockService.deleteOneFrontendBlock(id);
	}
}
