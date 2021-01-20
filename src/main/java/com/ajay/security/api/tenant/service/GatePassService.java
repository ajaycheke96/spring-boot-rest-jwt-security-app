package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.GatePass;
import com.ajay.security.api.tenant.repository.GatePassRepository;

@Service
@Transactional
public class GatePassService {

	@Autowired
	private GatePassRepository gatePassRepository;

	public List<GatePass> getAllGatePasss() {
		return gatePassRepository.findAll();
	}

	public GatePass getOneGatePass(Integer id) {
		return gatePassRepository.findById(id).get();
	}

	public String saveGatePass(GatePass gatePass) {
		return gatePassRepository.save(gatePass) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateGatePass(GatePass gatePass) {
		return gatePassRepository.save(gatePass) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneGatePass(Integer id) {
		gatePassRepository.deleteById(id);
		return " successfully deleted!";
	}
}
