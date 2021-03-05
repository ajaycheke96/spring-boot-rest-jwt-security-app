package com.ajay.security.api.tenant.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ajay.security.api.tenant.entity.GatePass;
import com.ajay.security.api.tenant.model.ApiResponse;
import com.ajay.security.api.tenant.service.GatePassService;

@RestController
@RequestMapping("/gatePass")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GatePassController {

	@Autowired
	private GatePassService gatePassService;

	@GetMapping("/listAllGatePass")
	public ApiResponse getAllGatePass() {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "list of GatePass",
					gatePassService.getAllGatePasss());
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"GatePass Service exception : " + e.getLocalizedMessage());
		}
	}

	@GetMapping("/{id}")
	public ApiResponse getOneGatePass(@PathVariable Integer id) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "GatePass", gatePassService.getOneGatePass(id));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"GatePass Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/saveGatePass")
	public ApiResponse saveGatePass(@RequestBody GatePass gatePass) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "GatePass saved!",
					gatePassService.saveGatePass(gatePass));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"GatePass Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/updateGatePass")
	public ApiResponse updateGatePass(@RequestBody GatePass gatePass) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, "GatePass updated!",
					gatePassService.saveGatePass(gatePass));
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"GatePass Service exception : " + e.getLocalizedMessage());
		}
	}

	@PostMapping("/deleteGatePass")
	public ApiResponse deleteOneGatePass(@RequestBody GatePass gatePass) {
		try {
			return new ApiResponse(LocalDateTime.now(), 200, null, gatePassService.deleteOneGatePass(gatePass), null);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
					"GatePass Service exception : " + e.getLocalizedMessage());
		}
	}
}
