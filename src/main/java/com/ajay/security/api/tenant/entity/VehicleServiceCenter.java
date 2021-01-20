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
 * The persistent class for the vehicle_service_centers database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "vehicle_service_centers")
public class VehicleServiceCenter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "address_line_1")
	private String addressLine1;

	@Column(name = "address_line_2")
	private String addressLine2;

	@Column(name = "alternate_phone")
	private String alternatePhone;

	private String city;

	@Column(name = "contact_person")
	private String contactPerson;

	@Column(name = "contact_person_email")
	private String contactPersonEmail;

	@Column(name = "contact_person_phone")
	private String contactPersonPhone;

	private String country;

	@Column(name = "created_at")
	private Timestamp createdAt;

	private String email;

	private String name;

	@Lob
	private String options;

	private String phone;

	private String state;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	private String zipcode;

	// bi-directional many-to-one association to VehicleServiceRecord
	@OneToMany(mappedBy = "vehicleServiceCenter",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<VehicleServiceRecord> vehicleServiceRecords;

}