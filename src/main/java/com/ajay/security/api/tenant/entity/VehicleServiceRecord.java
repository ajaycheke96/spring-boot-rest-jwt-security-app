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
 * The persistent class for the vehicle_service_records database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vehicle_service_records")
public class VehicleServiceRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 10)
	private BigDecimal amount;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_service")
	private Date dateOfService;

	@Column(length = 50)
	private String description;

	private int log;

	@Temporal(TemporalType.DATE)
	@Column(name = "next_due_date")
	private Date nextDueDate;

	@Column(name = "next_due_log")
	private int nextDueLog;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional many-to-one association to Vehicle
	@ManyToOne
	private Vehicle vehicle;

	// bi-directional many-to-one association to VehicleServiceCenter
	@ManyToOne
	@JoinColumn(name = "vehicle_service_center_id")
	private VehicleServiceCenter vehicleServiceCenter;

}