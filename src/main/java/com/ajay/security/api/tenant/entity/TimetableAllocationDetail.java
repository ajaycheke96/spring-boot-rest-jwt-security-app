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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the timetable_allocation_details database table.
 * 
 */
@Data
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
	private Timestamp createdAt;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to ClassTimingSession
	@ManyToOne
	@JoinColumn(name = "class_timing_session_id")
	private ClassTimingSession classTimingSession;

	// bi-directional many-to-one association to Subject
	@ManyToOne
	private Subject subject;

	// bi-directional many-to-one association to TimetableAllocation
	@ManyToOne
	@JoinColumn(name = "timetable_allocation_id")
	private TimetableAllocation timetableAllocation;

}