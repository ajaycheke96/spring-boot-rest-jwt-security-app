package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the syllabuses database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "syllabuses")
public class Syllabus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(name = "is_locked")
	private byte isLocked;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String status;

	@Column(length = 50)
	private String title;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to SyllabusDetail
	@OneToMany(mappedBy = "syllabus")
	private List<SyllabusDetail> syllabusDetails;

	// bi-directional many-to-one association to SyllabusTopic
	@OneToMany(mappedBy = "syllabus")
	private List<SyllabusTopic> syllabusTopics;

	// bi-directional many-to-one association to Employee
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Employee.class)
	@JoinColumn(name = "employee_id")
	private Employee employee;

	// bi-directional many-to-one association to Subject
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Subject.class)
	@JoinColumn(name = "subject_id")
	private Subject subject;

}