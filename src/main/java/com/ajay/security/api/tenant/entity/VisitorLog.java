package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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
 * The persistent class for the visitor_logs database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "visitor_logs")
public class VisitorLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Lob
	private String address;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_visit")
	private Date dateOfVisit;

	@Column(name = "entry_time")
	private Time entryTime;

	@Column(name = "exit_time")
	private Time exitTime;

	private String name;

	@Lob
	private String options;

	@Column(name = "relation_with_student")
	private String relationWithStudent;

	@Lob
	private String remarks;

	private String type;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	private String uuid;

	@Column(name = "visitor_count")
	private int visitorCount;

	// bi-directional many-to-one association to Employee
	@ManyToOne
	private Employee employee;

	// bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

	// bi-directional many-to-one association to VisitingPurpos
	@ManyToOne
	@JoinColumn(name = "visiting_purpose_id")
	private VisitingPurpos visitingPurpos;

}