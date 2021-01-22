package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "address_line_1", length = 50)
	private String addressLine1;

	@Column(name = "address_line_2", length = 50)
	private String addressLine2;

	@Column(name = "alternate_phone", length = 20)
	private String alternatePhone;

	@Column(length = 20)
	private String city;

	@Column(name = "contact_person", length = 50)
	private String contactPerson;

	@Column(name = "contact_person_email", length = 50)
	private String contactPersonEmail;

	@Column(name = "contact_person_phone", length = 50)
	private String contactPersonPhone;

	@Column(length = 20)
	private String country;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String email;

	@Column(length = 50)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(length = 20)
	private String phone;

	@Column(length = 20)
	private String state;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(length = 20)
	private String zipcode;

	// bi-directional many-to-one association to VehicleServiceRecord
	@OneToMany(mappedBy = "vehicleServiceCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<VehicleServiceRecord> vehicleServiceRecords;

}