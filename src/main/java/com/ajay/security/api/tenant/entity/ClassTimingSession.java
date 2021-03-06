package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
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
 * The persistent class for the class_timing_sessions database table.
 * 
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "class_timing_sessions")
public class ClassTimingSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	private Time end;

	@Column(name = "is_a_break")
	private byte isABreak;

	@Column(length = 20)
	private String name;

	@Column(length = 50)
	private String options;

	private Time start;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to ClassTiming
	@ManyToOne(targetEntity = ClassTiming.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "class_timing_id")
	private ClassTiming classTiming;

//	// bi-directional many-to-one association to TimetableAllocationDetail
//	@OneToMany(mappedBy = "classTimingSession")
//	@JsonIgnoreProperties("classTimingSession")
//	private List<TimetableAllocationDetail> timetableAllocationDetails;

}