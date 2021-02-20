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
 * The persistent class for the fee_allocations database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "fee_allocations")
public class FeeAllocation implements Serializable {
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

	@Column(length = 50)
	private String uuid;

//	// bi-directional many-to-one association to FeeAllocationGroup
////	@OneToMany(mappedBy = "feeAllocation")
//	@OneToMany(targetEntity = FeeAllocationGroup.class)
//	private List<FeeAllocationGroup> feeAllocationGroups;

	// bi-directional many-to-one association to Batch
	@ManyToOne(targetEntity = Batch.class)
	@JoinColumn(name = "batch_id")
	private Batch batch;

	// bi-directional many-to-one association to Cours
	@ManyToOne(targetEntity = Course.class)
	@JoinColumn(name = "course_id")
	private Course cours;

//	// bi-directional many-to-one association to StudentRecord
//	@OneToMany(mappedBy = "feeAllocation")
//	private List<StudentRecord> studentRecords;

}