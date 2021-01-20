package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the vehicles database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "is_active")
	private byte isActive;

	@Column(name = "is_owned")
	private byte isOwned;

	private String make;

	@Column(name = "max_allowed")
	private int maxAllowed;

	@Column(name = "max_fuel_capacity")
	private BigDecimal maxFuelCapacity;

	@Column(name = "max_seating_capacity")
	private int maxSeatingCapacity;

	private String model;

	private String name;

	@Lob
	private String options;

	@Column(name = "owner_company_name")
	private String ownerCompanyName;

	@Column(name = "owner_email")
	private String ownerEmail;

	@Column(name = "owner_name")
	private String ownerName;

	@Column(name = "owner_phone")
	private String ownerPhone;

	@Column(name = "registration_number")
	private String registrationNumber;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Bill
	@OneToMany(mappedBy = "vehicle1",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Bill> bills1;

	// bi-directional many-to-one association to Bill
	@OneToMany(mappedBy = "vehicle2",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Bill> bills2;

	// bi-directional many-to-one association to VehicleDocument
	@OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<VehicleDocument> vehicleDocuments;

	// bi-directional many-to-one association to VehicleFuel
	@OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<VehicleFuel> vehicleFuels;

	// bi-directional many-to-one association to VehicleIncharge
	@OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<VehicleIncharge> vehicleIncharges;

	// bi-directional many-to-one association to VehicleLog
	@OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<VehicleLog> vehicleLogs;

	// bi-directional many-to-one association to VehiclePerformanceCriteria
	@OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<VehiclePerformanceCriteria> vehiclePerformanceCriterias;

	// bi-directional many-to-one association to VehicleServiceRecord
	@OneToMany(mappedBy = "vehicle",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<VehicleServiceRecord> vehicleServiceRecords;

	// bi-directional many-to-one association to VehicleFuelType
	@ManyToOne
	@JoinColumn(name = "vehicle_fuel_type_id")
	private VehicleFuelType vehicleFuelType;

}