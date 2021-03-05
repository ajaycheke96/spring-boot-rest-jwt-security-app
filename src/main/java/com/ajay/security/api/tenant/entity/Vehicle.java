package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the vehicles database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vehicles")
public class Vehicle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(name = "is_active")
	private byte isActive;

	@Column(name = "is_owned")
	private byte isOwned;

	@Column(length = 50)
	private String make;

	@Column(name = "max_allowed")
	private int maxAllowed;

	@Column(name = "max_fuel_capacity")
	private BigDecimal maxFuelCapacity;

	@Column(name = "max_seating_capacity")
	private int maxSeatingCapacity;

	@Column(length = 50)
	private String model;

	@Column(length = 50)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(name = "owner_company_name", length = 50)
	private String ownerCompanyName;

	@Column(name = "owner_email", length = 50)
	private String ownerEmail;

	@Column(name = "owner_name", length = 50)
	private String ownerName;

	@Column(name = "owner_phone", length = 20)
	private String ownerPhone;

	@Column(name = "registration_number", length = 50)
	private String registrationNumber;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to Bill
//	@OneToMany(mappedBy = "vehicle1")
//	@JsonIgnoreProperties("vehicle1")
//	private List<Bill> bills1;

//	// bi-directional many-to-one association to Bill
//	@OneToMany(mappedBy = "vehicle2")
//	@JsonIgnoreProperties("vehicle2")
//	private List<Bill> bills2;

	// bi-directional many-to-one association to VehicleDocument
//	@OneToMany(mappedBy = "vehicle")
	@OneToMany(targetEntity = VehicleDocument.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_id")
	private List<VehicleDocument> vehicleDocuments;

	// bi-directional many-to-one association to VehicleFuel
//	@OneToMany(mappedBy = "vehicle")
	@OneToMany(targetEntity = VehicleFuel.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_id")
	private List<VehicleFuel> vehicleFuels;

	// bi-directional many-to-one association to VehicleIncharge
//	@OneToMany(targetEntity = VehicleIncharge.class, cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "vehicle")
	@JsonIgnoreProperties("vehicle")
	private List<VehicleIncharge> vehicleIncharges;

	// bi-directional many-to-one association to VehicleLog
//	@OneToMany(targetEntity = VehicleLog.class)
	@OneToMany(mappedBy = "vehicle")
	@JsonIgnoreProperties("vehicle")
	private List<VehicleLog> vehicleLogs;

	// bi-directional many-to-one association to VehiclePerformanceCriteria
//	@OneToMany(targetEntity = VehiclePerformanceCriteria.class, cascade = CascadeType.ALL)
	@OneToMany(mappedBy = "vehicle")
	@JsonIgnoreProperties("vehicle")
	private List<VehiclePerformanceCriteria> vehiclePerformanceCriterias;

//	// bi-directional many-to-one association to VehicleServiceRecord
//	@OneToMany(mappedBy = "vehicle")
//	@JsonIgnoreProperties("vehicle")
//	private List<VehicleServiceRecord> vehicleServiceRecords;

	// bi-directional many-to-one association to VehicleFuelType
	@ManyToOne(targetEntity = VehicleFuelType.class)
	@JoinColumn(name = "vehicle_fuel_type_id")
	private VehicleFuelType vehicleFuelType;

}