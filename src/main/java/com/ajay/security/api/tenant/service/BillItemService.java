package com.ajay.security.api.tenant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.BillItem;
import com.ajay.security.api.tenant.repository.BillItemRepository;

@Service
public class BillItemService {

	@Autowired
	private BillItemRepository billItemRepository;

	public List<BillItem> getAllBillItems() {
		return billItemRepository.findAll();
	}

	public BillItem getOneBillItem(Integer id) {
		return billItemRepository.findById(id).get();
	}

	public String saveBillItem(BillItem billItem) {
		return billItemRepository.save(billItem) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBillItem(BillItem billItem) {
		return billItemRepository.save(billItem) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBillItem(Integer id) {
		billItemRepository.deleteById(id);
		return " successfully deleted!";
	}
}
