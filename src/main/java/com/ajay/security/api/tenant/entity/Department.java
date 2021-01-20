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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the departments database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "departments")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String description;

	@Column(length = 20)
	private String name;

	@Lob
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to CommunicationDepartment
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<CommunicationDepartment> communicationDepartments;

	// bi-directional many-to-one association to EmployeeDesignation
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EmployeeDesignation> employeeDesignations;

	// bi-directional many-to-one association to EventDepartment
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EventDepartment> eventDepartments;

	// bi-directional many-to-one association to MeetingDepartment
	@OneToMany(mappedBy = "department",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<MeetingDepartment> meetingDepartments;

}