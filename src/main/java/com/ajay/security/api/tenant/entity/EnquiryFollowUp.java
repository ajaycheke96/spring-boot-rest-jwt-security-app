package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
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
 * The persistent class for the enquiry_follow_ups database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "enquiry_follow_ups")
public class EnquiryFollowUp implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_follow_up")
	private Date dateOfFollowUp;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_next_follow_up")
	private Date dateOfNextFollowUp;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String remarks;

	@Column(length = 20)
	private String status;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Enquiry
	@ManyToOne
	private Enquiry enquiry;

	// bi-directional many-to-one association to User
	@ManyToOne
	private User user;

}