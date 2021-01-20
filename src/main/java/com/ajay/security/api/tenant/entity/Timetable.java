package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the timetables database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "timetables")
public class Timetable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_effective")
	private Date dateEffective;

	@Lob
	private String description;

	@Lob
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	private String uuid;

	// bi-directional many-to-one association to TimetableAllocation
	@OneToMany(mappedBy = "timetable",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<TimetableAllocation> timetableAllocations;

	// bi-directional many-to-one association to Batch
	@ManyToOne
	private Batch batch;

}