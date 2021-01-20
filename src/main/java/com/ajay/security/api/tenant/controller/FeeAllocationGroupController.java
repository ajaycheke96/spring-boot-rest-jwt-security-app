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

import com.ajay.security.api.tenant.entity.FeeAllocationGroup;
import com.ajay.security.api.tenant.service.FeeAllocationGroupService;

@RestController
@RequestMapping("/feeAllocationGroup")
public class FeeAllocationGroupController {

	@Autowired
	private FeeAllocationGroupService feeAllocationGroupService;

	@GetMapping("/all")
	public List<FeeAllocationGroup> getAllFeeAllocationGroup() {
		return feeAllocationGroupService.getAllFeeAllocationGroups();
	}

	@GetMapping("/one/{id}")
	public FeeAllocationGroup getOneFeeAllocationGroup(@PathVariable Integer id) {
		return feeAllocationGroupService.getOneFeeAllocationGroup(id);
	}

	@PostMapping("/save")
	public String saveFeeAllocationGroup(@RequestBody FeeAllocationGroup feeAllocationGroup) {
		return feeAllocationGroupService.saveFeeAllocationGroup(feeAllocationGroup);
	}

	@PutMapping("/update")
	public String updateFeeAllocationGroup(@RequestBody FeeAllocationGroup feeAllocationGroup) {
		return feeAllocationGroupService.updateFeeAllocationGroup(feeAllocationGroup);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFeeAllocationGroup(@PathVariable Integer id) {
		return feeAllocationGroupService.deleteOneFeeAllocationGroup(id);
	}
}
