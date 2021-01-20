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

import com.ajay.security.api.tenant.entity.FeeInstallmentDetail;
import com.ajay.security.api.tenant.service.FeeInstallmentDetailService;

@RestController
@RequestMapping("/feeInstallmentDetail")
public class FeeInstallmentDetailController {

	@Autowired
	private FeeInstallmentDetailService feeInstallmentDetailService;

	@GetMapping("/all")
	public List<FeeInstallmentDetail> getAllFeeInstallmentDetail() {
		return feeInstallmentDetailService.getAllFeeInstallmentDetails();
	}

	@GetMapping("/one/{id}")
	public FeeInstallmentDetail getOneFeeInstallmentDetail(@PathVariable Integer id) {
		return feeInstallmentDetailService.getOneFeeInstallmentDetail(id);
	}

	@PostMapping("/save")
	public String saveFeeInstallmentDetail(@RequestBody FeeInstallmentDetail feeInstallmentDetail) {
		return feeInstallmentDetailService.saveFeeInstallmentDetail(feeInstallmentDetail);
	}

	@PutMapping("/update")
	public String updateFeeInstallmentDetail(@RequestBody FeeInstallmentDetail feeInstallmentDetail) {
		return feeInstallmentDetailService.updateFeeInstallmentDetail(feeInstallmentDetail);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneFeeInstallmentDetail(@PathVariable Integer id) {
		return feeInstallmentDetailService.deleteOneFeeInstallmentDetail(id);
	}
}
