package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the vehicle_fuels database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vehicle_fuels")
public class VehicleFuel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_fueling")
	private Date dateOfFueling;

	@Column(length = 50)
	private String description;

	private int log;

	@Column(length = 50)
	private String options;

	@Column(name = "price_per_unit")
	private BigDecimal pricePerUnit;

	private BigDecimal quantity;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to VehicleFuelType
	@ManyToOne
	@JoinColumn(name = "vehicle_fuel_type_id")
	private VehicleFuelType vehicleFuelType;

	// bi-directional many-to-one association to Vehicle
	@ManyToOne
	private Vehicle vehicle;

}