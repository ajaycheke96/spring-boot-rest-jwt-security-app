package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.FeeHead;
import com.ajay.security.api.tenant.repository.FeeHeadRepository;

@Service
@Transactional
public class FeeHeadService {

	@Autowired
	private FeeHeadRepository feeHeadRepository;

	public List<FeeHead> getAllFeeHeads() {
		return feeHeadRepository.findAll();
	}

	public FeeHead getOneFeeHead(Integer id) {
		return feeHeadRepository.findById(id).get();
	}

	public FeeHead saveFeeHead(FeeHead feeHead) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (feeHead.getCreatedAt() == null)
			feeHead.setCreatedAt(currentTimestamp);
		feeHead.setUpdatedAt(currentTimestamp);
		return feeHeadRepository.save(feeHead);
	}

	public String deleteOneFeeHead(FeeHead feeHead) {
		String result = null;
		if (feeHeadRepository.existsById(feeHead.getId())) {
			feeHeadRepository.delete(feeHead);
			result = " FeeHead deleted!";
		} else {
			result = "FeeHead Not Found! or Already deleted!";
		}
		return result;
	}
}
