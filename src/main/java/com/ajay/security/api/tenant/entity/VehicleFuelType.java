package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the vehicle_fuel_types database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vehicle_fuel_types")
public class VehicleFuelType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String description;

	private String name;

	@Lob
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to VehicleFuel
	@OneToMany(mappedBy = "vehicleFuelType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<VehicleFuel> vehicleFuels;

	// bi-directional many-to-one association to Vehicle
	@OneToMany(mappedBy = "vehicleFuelType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Vehicle> vehicles;

}