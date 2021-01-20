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
 * The persistent class for the fee_installment_details database table.
 * 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "fee_installment_details")
public class FeeInstallmentDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	private Integer id;

	@Column(length = 20)
	private int amount;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "is_optional")
	private byte isOptional;

	@Column(length = 50)
	private String options;

	@Column(name = "updated_at")
	private Timestamp updatedAt;

	// bi-directional many-to-one association to FeeHead
	@ManyToOne
	@JoinColumn(name = "fee_head_id")
	private FeeHead feeHead;

	// bi-directional many-to-one association to FeeInstallment
	@ManyToOne
	@JoinColumn(name = "fee_installment_id")
	private FeeInstallment feeInstallment;

}