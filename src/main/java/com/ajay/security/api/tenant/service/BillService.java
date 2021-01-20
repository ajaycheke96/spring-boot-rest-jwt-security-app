package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Bill;
import com.ajay.security.api.tenant.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

	public Bill getOneBill(Integer id) {
		return billRepository.findById(id).get();
	}

	public String saveBill(Bill bill) {
		return billRepository.save(bill) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBill(Bill bill) {
		return billRepository.save(bill) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBill(Integer id) {
		billRepository.deleteById(id);
		return " successfully deleted!";
	}
}
