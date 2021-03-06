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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the student_attendances database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_attendances")
public class StudentAttendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 20)
	private String attendance;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(name = "date_of_attendance")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfAttendance;

	@Column(name = "is_default", length = 20)
	private String isDefault;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String session;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Batch
	@ManyToOne(targetEntity = Batch.class)
	@JoinColumn(name = "batch_id")
	private Batch batch;

	// bi-directional many-to-one association to Subject
	@ManyToOne(targetEntity = Subject.class)
	@JoinColumn(name = "subject_id")
	private Subject subject;
}