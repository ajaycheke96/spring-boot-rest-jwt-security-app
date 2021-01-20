package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the transport_circles database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "transport_circles")
public class TransportCircle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String description;

	private String name;

	@Lob
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to StudentFeeRecord
	@OneToMany(mappedBy = "transportCircle",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<StudentFeeRecord> studentFeeRecords;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne
	@JoinColumn(name = "academic_session_id")
	private AcademicSession academicSession;

	// bi-directional many-to-one association to TransportFeeDetail
	@OneToMany(mappedBy = "transportCircle",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<TransportFeeDetail> transportFeeDetails;

}