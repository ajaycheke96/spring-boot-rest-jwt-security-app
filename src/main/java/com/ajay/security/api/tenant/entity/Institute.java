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
 * The persistent class for the institutes database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "institutes")
public class Institute implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 100)
	private String address;

	@Column(name = "alternate_contact_number", length = 20)
	private String alternateContactNumber;

	@Column(name = "contact_number", length = 20)
	private String contactNumber;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 20)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(name = "principal_name", length = 30)
	private String principalName;

	@Column(length = 50)
	private String remarks;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(length = 100)
	private String website;

	// bi-directional many-to-one association to EnquiryDetail
	@OneToMany(mappedBy = "institute", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<EnquiryDetail> enquiryDetails;

	// bi-directional many-to-one association to Registration
	@OneToMany(mappedBy = "institute", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Registration> registrations;

}