package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
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

	public GatePass saveGatePass(GatePass gatePass) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (gatePass.getCreatedAt() == null)
			gatePass.setCreatedAt(currentTimestamp);
		gatePass.setUpdatedAt(currentTimestamp);
		return gatePassRepository.save(gatePass);
	}

	public String deleteOneGatePass(GatePass gatePass) {
		String result = null;
		if (gatePassRepository.existsById(gatePass.getId())) {
			gatePassRepository.delete(gatePass);
			result = "GatePass deleted!";
		} else {
			result = "GatePass not found! or Already deleted!";
		}
		return result;
	}
}
