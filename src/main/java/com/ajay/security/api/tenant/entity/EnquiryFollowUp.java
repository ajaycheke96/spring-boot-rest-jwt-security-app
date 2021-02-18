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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the enquiry_follow_ups database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Enquiry
	@ManyToOne(targetEntity = Enquiry.class)
	@JoinColumn(name = "enquiry_id")
	private Enquiry enquiry;

	// bi-directional many-to-one association to User
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	@JsonIgnoreProperties({ "password", "backups", "postalRecords", "todos", "uploads", "userPreferences",
			"userPushTokens" })
	private User user;

}