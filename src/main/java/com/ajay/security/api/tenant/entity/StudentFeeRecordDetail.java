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
 * The persistent class for the student_fee_record_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "student_fee_record_details")
public class StudentFeeRecordDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 20)
	private int amount;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to FeeHead
	@ManyToOne
	@JoinColumn(name = "fee_head_id")
	private FeeHead feeHead;

	// bi-directional many-to-one association to StudentFeeRecord
	@ManyToOne
	@JoinColumn(name = "student_fee_record_id")
	private StudentFeeRecord studentFeeRecord;

	// bi-directional many-to-one association to Transaction
	@ManyToOne
	private Transaction transaction;

}