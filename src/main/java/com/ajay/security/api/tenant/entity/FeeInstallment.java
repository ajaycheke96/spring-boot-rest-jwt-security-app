package com.ajay.security.api.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The persistent class for the fee_installments database table.
 * 
 */
//@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "fee_installments")
public class FeeInstallment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(name = "created_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp createdAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	private Date dueDate;

	@Column(name = "late_fee")
	private int lateFee;

	@Column(name = "late_fee_applicable")
	private byte lateFeeApplicable;

	@Column(name = "late_fee_frequency", length = 50)
	private String lateFeeFrequency;

	@Column(length = 50)
	private String options;

	@Column(length = 50)
	private String title;

	@Column(name = "updated_at")
	@JsonFormat(pattern = "yyyy-MM-dd 'T' HH:mm:ss", timezone = "IST")
	private Timestamp updatedAt;

	@Column(length = 50)
	private String uuid;

	// bi-directional many-to-one association to FeeInstallmentDetail
//	@OneToMany(mappedBy = "feeInstallment")
	@OneToMany(targetEntity = FeeInstallmentDetail.class)
	@JoinColumn(name = "fee_installment_id")
	private List<FeeInstallmentDetail> feeInstallmentDetails;

	// bi-directional many-to-one association to FeeAllocationGroup
	@ManyToOne(targetEntity = FeeAllocationGroup.class)
	@JoinColumn(name = "fee_allocation_group_id")
	private FeeAllocationGroup feeAllocationGroup;

	// bi-directional many-to-one association to TransportFee
	@ManyToOne(targetEntity = TransportFee.class)
	@JoinColumn(name = "transport_fee_id")
	private TransportFee transportFee;

//	// bi-directional many-to-one association to StudentFeeRecord
//	@OneToMany(mappedBy = "feeInstallment")
//	private List<StudentFeeRecord> studentFeeRecords;

}