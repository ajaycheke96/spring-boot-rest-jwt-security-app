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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the vehicle_performance_criterias database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vehicle_performance_criterias")
public class VehiclePerformanceCriteria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_effective")
	private Date dateEffective;

	@Column(length = 50)
	private String description;

	@Column(name = "max_mileage")
	private BigDecimal maxMileage;

	@Column(name = "max_run")
	private int maxRun;

	@Column(name = "max_service_charge")
	private BigDecimal maxServiceCharge;

	@Column(name = "min_mileage")
	private BigDecimal minMileage;

	@Column(name = "min_run")
	private int minRun;

	@Column(name = "min_service_charge")
	private BigDecimal minServiceCharge;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Vehicle
	@ManyToOne
	private Vehicle vehicle;

}