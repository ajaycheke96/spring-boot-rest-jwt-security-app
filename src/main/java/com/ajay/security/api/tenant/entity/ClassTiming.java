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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the class_timings database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "class_timings")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
	@OneToMany(mappedBy = "classTiming", fetch = FetchType.EAGER)
//	@JsonManagedReference
	private List<ClassTimingSession> classTimingSessions;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne
	@JoinColumn(name = "academic_session_id", insertable = false, updatable = false)
//	@JsonBackReference
	private AcademicSession academicSession;

	// bi-directional many-to-one association to TimetableAllocation
	@OneToMany(mappedBy = "classTiming", fetch = FetchType.LAZY)
	private List<TimetableAllocation> timetableAllocations;

}