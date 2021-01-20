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
 * The persistent class for the employee_categories database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "employee_categories")
public class EmployeeCategory implements Serializable {
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

	// bi-directional many-to-one association to CommunicationEmployeeCategory
	@OneToMany(mappedBy = "employeeCategory",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<CommunicationEmployeeCategory> communicationEmployeeCategories;

	// bi-directional many-to-one association to Designation
	@OneToMany(mappedBy = "employeeCategory",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Designation> designations;

	// bi-directional many-to-one association to EventEmployeeCategory
	@OneToMany(mappedBy = "employeeCategory",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<EventEmployeeCategory> eventEmployeeCategories;

	// bi-directional many-to-one association to MeetingEmployeeCategory
	@OneToMany(mappedBy = "employeeCategory",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<MeetingEmployeeCategory> meetingEmployeeCategories;

}