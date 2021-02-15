package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the admissions database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "admissions")
public class Admission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Lob
	@Column(name = "admission_remarks", length = 20)
	private String admissionRemarks;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_admission")
	private Date dateOfAdmission;

	private int number;

	@Lob
	@Column(length = 20)
	private String options;

	@Column(length = 20)
	private String prefix;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to Batch
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Batch.class)
	@JoinColumn(name = "batch_id")
	private Batch batch;

	// bi-directional many-to-one association to Registration
	@ManyToOne
	private Registration registration;

	// bi-directional many-to-one association to StudentRecord
	@OneToMany(mappedBy = "admission", fetch = FetchType.LAZY)
	private List<StudentRecord> studentRecords;
}