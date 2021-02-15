package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class ClassTiming implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
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
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

//	// bi-directional many-to-one association to ClassTimingSession
//	@OneToMany(mappedBy = "classTiming", cascade = CascadeType.ALL)
////	@JoinColumn(name = "class_timing_id")
//	@JsonIgnoreProperties("classTiming")
//	private List<ClassTimingSession> classTimingSessions;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = AcademicSession.class)
	@JoinColumn(name = "academic_session_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer"})
	private AcademicSession academicSession;

//	// bi-directional many-to-one association to TimetableAllocation
//	@OneToMany(mappedBy = "classTiming")
////	@JoinColumn(name = "class_timing_id")
//	@JsonIgnoreProperties("classTiming")
//	private List<TimetableAllocation> timetableAllocations;

}