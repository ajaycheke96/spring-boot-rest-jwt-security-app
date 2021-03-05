package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ajay.security.api.tenant.entity.PaymentMethod;
import com.ajay.security.api.tenant.repository.PaymentMethodRepository;

@Service
@Transactional
public class PaymentMethodService {

	@Autowired
	private PaymentMethodRepository paymentMethodRepository;

	public List<PaymentMethod> getAllPaymentMethods() {
		return paymentMethodRepository.findAll();
	}

	public PaymentMethod getOnePaymentMethod(Integer id) {
		return paymentMethodRepository.findById(id).get();
	}

	public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		if (paymentMethod.getCreatedAt() == null)
			paymentMethod.setCreatedAt(currentTimestamp);
		paymentMethod.setUpdatedAt(currentTimestamp);
		return paymentMethodRepository.save(paymentMethod);
	}

	public String deleteOnePaymentMethod(PaymentMethod paymentMethod) {
		String result = null;
		if (paymentMethodRepository.existsById(paymentMethod.getId())) {
			paymentMethodRepository.delete(paymentMethod);
			result = " PaymentMethod deleted!";
		} else {
			result = "PaymentMethod Not Found! or Already deleted!";
		}
		return result;
	}
}
