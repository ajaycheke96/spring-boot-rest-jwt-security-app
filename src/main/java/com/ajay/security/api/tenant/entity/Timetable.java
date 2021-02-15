package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the timetables database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "timetables")
public class Timetable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_effective")
	private Date dateEffective;

	@Column(length = 50)
	private String description;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

//	// bi-directional many-to-one association to TimetableAllocation
//	@OneToMany(mappedBy = "timetable")
//	@JsonIgnoreProperties("timetable")
//	private List<TimetableAllocation> timetableAllocations;

	// bi-directional many-to-one association to Batch
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Batch.class)
	@JoinColumn(name = "batch_id")
	private Batch batch;
//	// bi-directional many-to-one association to Batch
//	@ManyToOne(fetch = FetchType.LAZY) // , targetEntity = Batch.class)
//	@JoinColumn(name = "batch_id")
//	@JsonIgnoreProperties({ "timetable", "hibernateLazyInitializer" })
//	private Batch batch;

}