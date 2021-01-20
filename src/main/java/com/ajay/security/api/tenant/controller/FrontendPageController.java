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

import com.ajay.security.api.tenant.entity.FrontendPage;
import com.ajay.security.api.tenant.service.FrontendPageService;

@RestController
@RequestMapping("/frontendPage")
public class FrontendPageController {

	@Autowired
	private FrontendPageService frontendPageService;

	@GetMapping("/all")
	public List<FrontendPage> getAllFrontendPage() {
		return frontendPageService.getAllFrontendPages();
	}

	@GetMapping("/one/{id}")
	public FrontendPage getOneFrontendPage(@PathVariable Integer id) {
		return frontendPageService.getOneFrontendPage(id);
	}

	@PostMapping("/save")
	public String saveFrontendPage(@RequestBody FrontendPage frontendPage) {
		return frontendPageService.saveFrontendPage(frontendPage);
	}

	@PutMapping("/update")
	public String updateFrontendPage(@RequestBody FrontendPage frontendPage) {
		return frontendPageService.updateFrontendPage(frontendPage);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFrontendPage(@PathVariable Integer id) {
		return frontendPageService.deleteOneFrontendPage(id);
	}
}
