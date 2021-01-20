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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the class_timings database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "class_timings")
public class ClassTiming implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	@Column(length = 50)
	private String description;

	@Column(length = 20)
	private String name;

	@Lob
	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to ClassTimingSession
	@OneToMany(mappedBy = "classTiming", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<ClassTimingSession> classTimingSessions;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne
	@JoinColumn(name = "academic_session_id")
	private AcademicSession academicSession;

	// bi-directional many-to-one association to TimetableAllocation
	@OneToMany(mappedBy = "classTiming",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<TimetableAllocation> timetableAllocations;

}