package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the exam_observations database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "exam_observations")
public class ExamObservation implements Serializable {
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

	@Column(length = 20)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

//	// bi-directional many-to-one association to Batch
//	@OneToMany(mappedBy = "examObservation")
//	private List<Batch> batches;

	// bi-directional many-to-one association to ExamObservationDetail
//	@OneToMany(mappedBy = "examObservation")
	@OneToMany(targetEntity = ExamObservationDetail.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "exam_observation_id")
	private List<ExamObservationDetail> examObservationDetails;

	// bi-directional many-to-one association to AcademicSession
	@ManyToOne(targetEntity = AcademicSession.class)
	@JoinColumn(name = "academic_session_id")
	private AcademicSession academicSession;

}