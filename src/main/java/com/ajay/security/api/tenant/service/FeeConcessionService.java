package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeConcession;
import com.ajay.security.api.tenant.repository.FeeConcessionRepository;

@Service
@Transactional
public class FeeConcessionService {

	@Autowired
	private FeeConcessionRepository feeConcessionRepository;

	public List<FeeConcession> getAllFeeConcessions() {
		return feeConcessionRepository.findAll();
	}

	public FeeConcession getOneFeeConcession(Integer id) {
		return feeConcessionRepository.findById(id).get();
	}

	public FeeConcession saveFeeConcession(FeeConcession feeConcession) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (feeConcession.getCreatedAt() == null)
			feeConcession.setCreatedAt(currentTimestamp);
		feeConcession.setUpdatedAt(currentTimestamp);

		if (!feeConcession.getFeeConcessionDetails().isEmpty())
			feeConcession.getFeeConcessionDetails().forEach(feeConcessionDetail -> {
				if (feeConcessionDetail.getCreatedAt() == null)
					feeConcessionDetail.setCreatedAt(currentTimestamp);
				feeConcessionDetail.setUpdatedAt(currentTimestamp);
			});
		return feeConcessionRepository.save(feeConcession);
	}

	public String deleteOneFeeConcession(FeeConcession feeConcession) {
		String result = null;
		if (feeConcessionRepository.existsById(feeConcession.getId())) {
			feeConcessionRepository.delete(feeConcession);
			result = " FeeConcession deleted!";
		} else {
			result = "FeeConcession Not Found! or Already deleted!";
		}
		return result;
	}
}
