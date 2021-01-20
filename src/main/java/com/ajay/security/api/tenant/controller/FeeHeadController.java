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

import com.ajay.security.api.tenant.entity.FeeHead;
import com.ajay.security.api.tenant.service.FeeHeadService;

@RestController
@RequestMapping("/feeHead")
public class FeeHeadController {

	@Autowired
	private FeeHeadService feeHeadService;

	@GetMapping("/all")
	public List<FeeHead> getAllFeeHead() {
		return feeHeadService.getAllFeeHeads();
	}

	@GetMapping("/one/{id}")
	public FeeHead getOneFeeHead(@PathVariable Integer id) {
		return feeHeadService.getOneFeeHead(id);
	}

	@PostMapping("/save")
	public String saveFeeHead(@RequestBody FeeHead feeHead) {
		return feeHeadService.saveFeeHead(feeHead);
	}

	@PutMapping("/update")
	public String updateFeeHead(@RequestBody FeeHead feeHead) {
		return feeHeadService.updateFeeHead(feeHead);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFeeHead(@PathVariable Integer id) {
		return feeHeadService.deleteOneFeeHead(id);
	}
}
