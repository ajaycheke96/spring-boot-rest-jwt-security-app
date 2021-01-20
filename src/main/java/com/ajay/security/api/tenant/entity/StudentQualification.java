package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the student_qualifications database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_qualifications")
public class StudentQualification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "board_name")
	private String boardName;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String description;

	@Column(name = "end_period")
	private String endPeriod;

	@Column(name = "institute_name")
	private String instituteName;

	@Lob
	private String options;

	private String result;

	private String standard;

	@Column(name = "start_period")
	private String startPeriod;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(name = "upload_token")
	private String uploadToken;

	// bi-directional many-to-one association to Student
	@ManyToOne
	private Student student;

}