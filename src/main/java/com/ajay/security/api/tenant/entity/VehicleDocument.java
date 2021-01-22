package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
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
 * The persistent class for the vehicle_documents database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vehicle_documents")
public class VehicleDocument implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_expiry")
	private Date dateOfExpiry;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String title;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to VehicleDocumentType
	@ManyToOne
	@JoinColumn(name = "vehicle_document_type_id")
	private VehicleDocumentType vehicleDocumentType;

	// bi-directional many-to-one association to Vehicle
	@ManyToOne
	private Vehicle vehicle;

}