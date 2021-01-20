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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the complaints database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "complaints")
public class Complaint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Lob
	@Column(length = 20)
	private String action;

	@Column(name = "complainant_address",length = 30)
	private String complainantAddress;

	@Column(name = "complainant_contact_number",length = 20)
	private String complainantContactNumber;

	@Column(name = "complainant_name",length = 20)
	private String complainantName;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_complaint")
	private Date dateOfComplaint;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_resolution")
	private Date dateOfResolution;

	@Lob
	@Column(length = 50)
	private String description;

	@Lob
	@Column(length = 50)
	private String options;

	@Lob
	@Column(length = 20)
	private String remarks;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token",length = 50)
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to ComplaintType
	@ManyToOne
	@JoinColumn(name = "complaint_type_id")
	private ComplaintType complaintType;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}