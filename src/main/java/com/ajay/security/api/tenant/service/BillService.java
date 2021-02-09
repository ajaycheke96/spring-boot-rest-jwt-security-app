package com.ajay.security.api.tenant.service;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajay.security.api.tenant.entity.Bill;
import com.ajay.security.api.tenant.repository.BillRepository;

@Service
@Transactional
public class BillService {

	@Autowired
	private BillRepository billRepository;

//	@Autowired
//	private EmployeeRepository employeeRepository;

//	@Autowired
//	private VehicleRepository vehicleRepository;

//	@Autowired
//	private StockItemRepository stockItemRepository;

	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

	public Bill getOneBill(Integer id) {
		return billRepository.findById(id).get();
	}

	public String saveBill(Bill bill) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		bill.setCreatedAt(timestamp);
		bill.setUpdatedAt(timestamp);

		// For BillItem
		if (!bill.getBillItems().isEmpty()) {
//			If BillItems not null & Setting to Bill entity
			bill.getBillItems().forEach(bi -> {
				bi.setCreatedAt(timestamp);
				bi.setUpdatedAt(timestamp);
				bi.setBill(bill);

				/**
				 * TODO: to add for StockItem and more
				 */
				// add StockItem by Id
//				if(bi.getStockItem().getId() != null) {
//					StockItem stockItem = stockItemRepository.findById(bi.getStockItem().getId()).orElseThrow();
//					stockItem.setBillItems(List.of(bi));
//				}

			});
		}

		/**
		 * TODO: for setting Employee & Vehicles
		 */
		// For Employee
		/*
		 * Employee employee = bill.getEmployee(); if (employee == null) throw new
		 * RuntimeException("Employee must no be null"); Employee existedEmployee =
		 * employeeRepository.findById(employee.getId()).orElseThrow();
		 * existedEmployee.setBills(List.of(bill)); bill.setEmployee(existedEmployee);
		 */

		// For Vehicle1
		/*
		 * Vehicle vehicle1 = bill.getVehicle1(); if (vehicle1 == null) throw new
		 * RuntimeException("Vehicle must not be null"); Vehicle existedVehicle1 =
		 * vehicleRepository.findById(vehicle1.getId()).orElseThrow();
		 * existedVehicle1.setBills1(List.of(bill)); bill.setVehicle1(existedVehicle1);
		 */

		// For Vehicle2
		/*
		 * Vehicle vehicle2 = bill.getVehicle2(); if (vehicle2 == null) throw new
		 * RuntimeException("Vehicle must not be null"); Vehicle existedVehicle2 =
		 * vehicleRepository.findById(vehicle2.getId()).orElseThrow();
		 * existedVehicle2.setBills1(List.of(bill)); bill.setVehicle1(existedVehicle2);
		 */

		// For Transaction

		if (!bill.getTransactions().isEmpty()) {
			bill.getTransactions().forEach(tx -> {
				tx.setCreatedAt(timestamp);
				tx.setUpdatedAt(timestamp);
				tx.setBill(bill);
			});

			/**
			 * TODO: set Transaction values and more
			 */
		}

		return billRepository.save(bill) != null ? " successfully saved!" : "Failed! Please try again!!";
	}

	public String updateBill(Bill bill) {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		bill.setUpdatedAt(timestamp);

		// For BillItem
		if (!bill.getBillItems().isEmpty()) {
//			If BillItems not null & Setting to Bill entity
			bill.getBillItems().forEach(bi -> {
				bi.setUpdatedAt(timestamp);
				bi.setBill(bill);

				/**
				 * TODO: to add for StockItem and more
				 */
				// add StockItem by Id
//				if(bi.getStockItem().getId() != null) {
//					StockItem stockItem = stockItemRepository.findById(bi.getStockItem().getId()).orElseThrow();
//					stockItem.setBillItems(List.of(bi));
//				}

			});
		}

		/**
		 * TODO: for setting Employee & Vehicles
		 */
		// For Employee
		/*
		 * Employee employee = bill.getEmployee(); if (employee == null) throw new
		 * RuntimeException("Employee must no be null"); Employee existedEmployee =
		 * employeeRepository.findById(employee.getId()).orElseThrow();
		 * existedEmployee.setBills(List.of(bill)); bill.setEmployee(existedEmployee);
		 */

		// For Vehicle1
		/*
		 * Vehicle vehicle1 = bill.getVehicle1(); if (vehicle1 == null) throw new
		 * RuntimeException("Vehicle must not be null"); Vehicle existedVehicle1 =
		 * vehicleRepository.findById(vehicle1.getId()).orElseThrow();
		 * existedVehicle1.setBills1(List.of(bill)); bill.setVehicle1(existedVehicle1);
		 */

		// For Vehicle2
		/*
		 * Vehicle vehicle2 = bill.getVehicle2(); if (vehicle2 == null) throw new
		 * RuntimeException("Vehicle must not be null"); Vehicle existedVehicle2 =
		 * vehicleRepository.findById(vehicle2.getId()).orElseThrow();
		 * existedVehicle2.setBills1(List.of(bill)); bill.setVehicle1(existedVehicle2);
		 */

		// For Transaction

		if (!bill.getTransactions().isEmpty()) {
			bill.getTransactions().forEach(tx -> {
				tx.setUpdatedAt(timestamp);
				tx.setBill(bill);
			});

			/**
			 * TODO: set Transaction values and more
			 */
		}

		return billRepository.save(bill) != null ? " successfully updated!" : "Failed! Please try again!!";
	}

	public String deleteOneBill(Integer id) {
		billRepository.deleteById(id);
		return " successfully deleted!";
	}
}
