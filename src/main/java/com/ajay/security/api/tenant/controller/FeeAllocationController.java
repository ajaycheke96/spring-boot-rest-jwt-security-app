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

import com.ajay.security.api.tenant.entity.FeeAllocation;
import com.ajay.security.api.tenant.service.FeeAllocationService;

@RestController
@RequestMapping("/feeAllocation")
public class FeeAllocationController {

	@Autowired
	private FeeAllocationService feeAllocationService;

	@GetMapping("/all")
	public List<FeeAllocation> getAllFeeAllocation() {
		return feeAllocationService.getAllFeeAllocations();
	}

	@GetMapping("/one/{id}")
	public FeeAllocation getOneFeeAllocation(@PathVariable Integer id) {
		return feeAllocationService.getOneFeeAllocation(id);
	}

	@PostMapping("/save")
	public String saveFeeAllocation(@RequestBody FeeAllocation feeAllocation) {
		return feeAllocationService.saveFeeAllocation(feeAllocation);
	}

	@PutMapping("/update")
	public String updateFeeAllocation(@RequestBody FeeAllocation feeAllocation) {
		return feeAllocationService.updateFeeAllocation(feeAllocation);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFeeAllocation(@PathVariable Integer id) {
		return feeAllocationService.deleteOneFeeAllocation(id);
	}
}
