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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the timetable_allocations database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "timetable_allocations")
public class TimetableAllocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String day;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to TimetableAllocationDetail
//	@OneToMany(mappedBy = "timetableAllocation")
////	@JsonIgnoreProperties("timetableAllocation")
//	private List<TimetableAllocationDetail> timetableAllocationDetails;

//	// bi-directional many-to-one association to ClassTiming
	@ManyToOne(fetch = FetchType.LAZY , targetEntity = ClassTiming.class)
	@JoinColumn(name = "class_timing_id")
//	@JsonIgnoreProperties({ "timetableAllocations", "hibernateLazyInitializer" })
	private ClassTiming classTiming;

	// bi-directional many-to-one association to Timetable
	@ManyToOne(fetch = FetchType.LAZY , targetEntity = Timetable.class)
	@JoinColumn(name = "timetable_id")
//	@JsonIgnoreProperties({ "timetableAllocations", "hibernateLazyInitializer" })
	private Timetable timetable;

}