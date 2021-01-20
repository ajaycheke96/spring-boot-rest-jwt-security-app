package com.ajay.security.api.tenant.service;

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

	public String savePaymentMethod(PaymentMethod paymentMethod) {
		return paymentMethodRepository.save(paymentMethod) != null ? " successfully saved!"
				: "Failed! Please try again!!";
	}

	public String updatePaymentMethod(PaymentMethod paymentMethod) {
		return paymentMethodRepository.save(paymentMethod) != null ? " successfully updated!"
				: "Failed! Please try again!!";
	}

	public String deleteOnePaymentMethod(Integer id) {
		paymentMethodRepository.deleteById(id);
		return " successfully deleted!";
	}
}
