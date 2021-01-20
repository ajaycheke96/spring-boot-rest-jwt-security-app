package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the fee_heads database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "fee_heads")
public class FeeHead implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(length = 50)
	private String description;

	@Column(length = 20)
	private String name;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to FeeConcessionDetail
	@OneToMany(mappedBy = "feeHead", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FeeConcessionDetail> feeConcessionDetails;

	// bi-directional many-to-one association to FeeGroup
	@ManyToOne
	@JoinColumn(name = "fee_group_id")
	private FeeGroup feeGroup;

	// bi-directional many-to-one association to FeeInstallmentDetail
	@OneToMany(mappedBy = "feeHead", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<FeeInstallmentDetail> feeInstallmentDetails;

	// bi-directional many-to-one association to StudentFeeRecordDetail
	@OneToMany(mappedBy = "feeHead", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StudentFeeRecordDetail> studentFeeRecordDetails;

	// bi-directional many-to-one association to StudentOptionalFeeRecord
	@OneToMany(mappedBy = "feeHead", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<StudentOptionalFeeRecord> studentOptionalFeeRecords;

}