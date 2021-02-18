package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the departments database table.
 * 
 */
//@Data
@Setter
@Getter
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	private String description;

	@Column(length = 20)
	private String name;

	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to CommunicationDepartment
//	@OneToMany(mappedBy = "department")
//	private List<CommunicationDepartment> communicationDepartments;

//	// bi-directional many-to-one association to EmployeeDesignation
//	@OneToMany(mappedBy = "department")
//	private List<EmployeeDesignation> employeeDesignations;

//	// bi-directional many-to-one association to EventDepartment
//	@OneToMany(mappedBy = "department")
//	private List<EventDepartment> eventDepartments;

//	// bi-directional many-to-one association to MeetingDepartment
//	@OneToMany(mappedBy = "department")
//	private List<MeetingDepartment> meetingDepartments;

}