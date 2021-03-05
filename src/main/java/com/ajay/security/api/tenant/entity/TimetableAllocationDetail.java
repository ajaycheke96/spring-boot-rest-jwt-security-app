package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;

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
 * The persistent class for the timetable_allocation_details database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "timetable_allocation_details")
public class TimetableAllocationDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to ClassTimingSession
	@ManyToOne(targetEntity = ClassTimingSession.class)
	@JoinColumn(name = "class_timing_session_id")
	private ClassTimingSession classTimingSession;

	// bi-directional many-to-one association to Subject
	@ManyToOne(targetEntity = Subject.class)
	@JoinColumn(name = "subject_id")
	private Subject subject;

//	// bi-directional many-to-one association to TimetableAllocation
//	@ManyToOne(targetEntity = TimetableAllocation.class)
//	@JoinColumn(name = "timetable_allocation_id")
//	private TimetableAllocation timetableAllocation;

}