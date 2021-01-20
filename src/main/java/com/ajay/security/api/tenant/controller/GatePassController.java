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

import com.ajay.security.api.tenant.entity.GatePass;
import com.ajay.security.api.tenant.service.GatePassService;

@RestController
@RequestMapping("/gatePass")
public class GatePassController {

	@Autowired
	private GatePassService gatePassService;

	@GetMapping("/all")
	public List<GatePass> getAllGatePass() {
		return gatePassService.getAllGatePasss();
	}

	@GetMapping("/one/{id}")
	public GatePass getOneGatePass(@PathVariable Integer id) {
		return gatePassService.getOneGatePass(id);
	}

	@PostMapping("/save")
	public String saveGatePass(@RequestBody GatePass gatePass) {
		return gatePassService.saveGatePass(gatePass);
	}

	@PutMapping("/update")
	public String updateGatePass(@RequestBody GatePass gatePass) {
		return gatePassService.updateGatePass(gatePass);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteOneGatePass(@PathVariable Integer id) {
		return gatePassService.deleteOneGatePass(id);
	}
}
