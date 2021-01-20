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

import com.ajay.security.api.tenant.entity.FeeConcessionDetail;
import com.ajay.security.api.tenant.service.FeeConcessionDetailService;

@RestController
@RequestMapping("/feeConcessionDetail")
public class FeeConcessionDetailController {

	@Autowired
	private FeeConcessionDetailService feeConcessionDetailService;

	@GetMapping("/all")
	public List<FeeConcessionDetail> getAllFeeConcessionDetail() {
		return feeConcessionDetailService.getAllFeeConcessionDetails();
	}

	@GetMapping("/one/{id}")
	public FeeConcessionDetail getOneFeeConcessionDetail(@PathVariable Integer id) {
		return feeConcessionDetailService.getOneFeeConcessionDetail(id);
	}

	@PostMapping("/save")
	public String saveFeeConcessionDetail(@RequestBody FeeConcessionDetail feeConcessionDetail) {
		return feeConcessionDetailService.saveFeeConcessionDetail(feeConcessionDetail);
	}

	@PutMapping("/update")
	public String updateFeeConcessionDetail(@RequestBody FeeConcessionDetail feeConcessionDetail) {
		return feeConcessionDetailService.updateFeeConcessionDetail(feeConcessionDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFeeConcessionDetail(@PathVariable Integer id) {
		return feeConcessionDetailService.deleteOneFeeConcessionDetail(id);
	}
}
